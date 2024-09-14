package com.nocountry.server.service;

import com.nocountry.server.model.dto.ProfessionalUpdateRequest;
import com.nocountry.server.model.dto.ProfessionalResponse;
import com.nocountry.server.model.entity.Professional;

import java.util.List;

public interface IProfessionalService {

    Professional findById(Long id);

    List<Professional> getAllProfessional();

    ProfessionalResponse updateProfessional(ProfessionalUpdateRequest request, Long id);

    boolean deleteProfessional(Long id);

    boolean existsProfessionalById(Long id);

    List<Professional> getProfessionalByCategory(Long categoryId);

    List<Professional> getProfessionalByAvailability(String availability);

}
