package com.nocountry.server.service;

import com.nocountry.server.model.dto.ProfessionalDto;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService implements IProfessionalService{

    @Autowired
    private ProfessionalRepository professionaRepo;

    @Autowired
    private UserService userService;

    @Override
    public Professional findById(Long id) {
        return professionaRepo.findById(id).get();
    }

    @Override
    public List<Professional> getAllProfessional() {
        return professionaRepo.findAll();
    }

    @Override
    public void createProfessional(ProfessionalDto professionalDto) {
        Professional professional = new Professional();

        professional.setAvailability(professionalDto.getAvailavility());
        professional.setDescription(professionalDto.getDescription());
        professional.setExperience(professionalDto.getExperience());
        professional.setUser(
                userService.findById(professionalDto.getUserId())
        );

        professionaRepo.save(professional);
    }

    @Override
    public void updateProfessional(ProfessionalDto professionalDto) {
        Professional professional = new Professional();

        professional.setAvailability(professionalDto.getAvailavility());
        professional.setDescription(professionalDto.getDescription());
        professional.setExperience(professionalDto.getExperience());

        professionaRepo.save(professional);
    }

    @Override
    public void deleteProfessional(Long id) {
        professionaRepo.deleteById(id);
    }
}
