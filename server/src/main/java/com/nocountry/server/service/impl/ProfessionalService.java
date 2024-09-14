package com.nocountry.server.service.impl;

import com.nocountry.server.exception.ProfessionalNotFoundException;
import com.nocountry.server.model.dto.ProfessionalUpdateRequest;
import com.nocountry.server.model.dto.ProfessionalResponse;
import com.nocountry.server.model.entity.Category;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.model.entity.User;
import com.nocountry.server.model.mappers.ProfessionalMapper;
import com.nocountry.server.repository.CategoryRepository;
import com.nocountry.server.repository.ProfessionalRepository;
import com.nocountry.server.service.IProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalService implements IProfessionalService {

    private final ProfessionalRepository professionalRepo;
    private final CategoryRepository categoryRepo;
    private final CategoryService categoryService;
    private final ProfessionalMapper profeMapper;

    @Override
    public Professional findById(Long id) {
        Optional<Professional> professional = professionalRepo.findById(id);
        return professional.orElseThrow(() -> new ProfessionalNotFoundException("The professional with that id (" + id + ") doesn't exists"));
    }

    @Override
    public List<Professional> getAllProfessional() {
        return professionalRepo.findAll();
    }

    @Transactional
    @Override
    public ProfessionalResponse updateProfessional(ProfessionalUpdateRequest request, Long id) {
        Professional professionalDb = professionalRepo.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundException("Professional not found"));

        Category category = categoryRepo.findById(request.categoryId())
                .orElseThrow(() -> new ProfessionalNotFoundException("Category not found"));

        User user = professionalDb.getUser();

        profeMapper.updateProfessionalFromRequest(request, professionalDb);

        user.setLocation(request.location());
        user.setUrlImage(request.urlImage());
        professionalDb.setUser(user);
        professionalDb.getCategories().add(category);
        return profeMapper.toProfessionalResponse(professionalRepo.save(professionalDb));
    }

    @Override
    public boolean deleteProfessional(Long id) {
        if(professionalRepo.existsById(id)){
            professionalRepo.deleteById(id);
            return true;
        }
            return false;
    }

    @Override
    public boolean existsProfessionalById(Long id) {
        return professionalRepo.existsById(id);
    }

    @Override
    public List<Professional> getProfessionalByCategory(Long categoryId) {
        Category category = categoryService.findCategoryById(categoryId);
        return professionalRepo.findAllByCategories(category);
    }

    @Override
    public List<Professional> getProfessionalByAvailability(String availability) {
        return professionalRepo.findAllByAvailability(availability);
    }


}
