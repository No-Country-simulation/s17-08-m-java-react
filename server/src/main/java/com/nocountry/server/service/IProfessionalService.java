package com.nocountry.server.service;

import com.nocountry.server.model.dto.ProfessionalUpdateRequest;
import com.nocountry.server.model.dto.ProfessionalResponse;
import com.nocountry.server.model.entity.Professional;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProfessionalService {

    ProfessionalResponse findById(Long id);

    Page<ProfessionalResponse> getAllProfessional(int page, int size);

    ProfessionalResponse updateProfessional(ProfessionalUpdateRequest request, Long id);

    boolean deleteProfessional(Long id);

    boolean existsProfessionalById(Long id);

    List<Professional> getProfessionalByCategory(Long categoryId);

    List<Professional> getProfessionalByAvailability(String availability);

}
