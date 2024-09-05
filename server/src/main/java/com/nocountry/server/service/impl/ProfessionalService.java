package com.nocountry.server.service.impl;

import com.nocountry.server.exception.ProfessionalNotFoundException;
import com.nocountry.server.model.dto.ProfessionalDto;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.repository.ProfessionalRepository;
import com.nocountry.server.service.IProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalService implements IProfessionalService {

    private final ProfessionalRepository professionalRepo;

    private final UserService userService;

    private final ProfessionalRepository professionalRepository;

    @Override
    public Professional findById(Long id) {
        Optional<Professional> professional =  professionalRepo.findById(id);
        return professional.orElseThrow(()-> new ProfessionalNotFoundException("The professional with that id (" +id+ ") doesn't exists"));
    }

    @Override
    public List<Professional> getAllProfessional() {
        return professionalRepo.findAll();
    }

    @Override
    public void createProfessional(ProfessionalDto professionalDto) {
        Professional professional = new Professional();

        professional.setAvailavility(professionalDto.getAvailavility());
        professional.setDescription(professionalDto.getDescription());
        professional.setExperience(professionalDto.getExperience());
        professional.setUser(
                userService.findById(professionalDto.getUserId())
        );

        professionalRepo.save(professional);
    }

    @Override
    public Professional updateProfessional(ProfessionalDto professionalDto, Long id) {
        if (professionalRepository.existsById(id)){
            Professional professional = findById(id);

            professional.setAvailavility(professionalDto.getAvailavility());
            professional.setDescription(professionalDto.getDescription());
            professional.setExperience(professionalDto.getExperience());



            return professionalRepo.save(professional);
            //professional updated
        }

        //the professional doesn't exists
        return null;

    }

    @Override
    public boolean deleteProfessional(Long id) {
        if(professionalRepo.existsById(id)){
            professionalRepo.deleteById(id);
            return true;
        }
        //the professional doesn't exists
            return false;

    }

    @Override
    public boolean existsProfessionalById(Long id) {
        return professionalRepository.existsById(id);
    }


}
