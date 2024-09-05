package com.nocountry.server.service;

import com.nocountry.server.model.dto.ServiceRequestDto;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.model.entity.ServiceRequest;

import java.util.List;

public interface IServiceRequestService {

    boolean createRequest(ServiceRequestDto dto);

    ServiceRequest findRequestById(Long id);

    List<ServiceRequest> findAllRequestByProfessionalId(Long professionalId);

    ServiceRequest updateRequest(ServiceRequestDto dto, Long id);

    boolean deleteRequest(Long id);
}
