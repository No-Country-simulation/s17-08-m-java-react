package com.nocountry.server.service;

import com.nocountry.server.model.dto.ProfessionalDto;
import com.nocountry.server.model.dto.UserDto;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.model.entity.User;

import java.util.List;

public interface IProfessionalService {

    Professional findById(Long id);

    List<Professional> getAllProfessional();

    void createProfessional(ProfessionalDto professionalDto);

    void updateProfessional(ProfessionalDto ProfessionalDto);

    void deleteProfessional(Long id);

}
