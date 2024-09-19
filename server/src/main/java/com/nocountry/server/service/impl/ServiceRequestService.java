package com.nocountry.server.service.impl;

import com.nocountry.server.exception.ProfessionalNotFoundException;
import com.nocountry.server.exception.ServiceRequestNotFound;
import com.nocountry.server.model.dto.ServiceRequestDto;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.model.entity.ServiceRequest;
import com.nocountry.server.model.entity.enums.ServiceStatus;
import com.nocountry.server.repository.ServiceRequestRepository;
import com.nocountry.server.service.IServiceRequestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceRequestService implements IServiceRequestService {

    private final ServiceRequestRepository requestRepository;
    private final ProfessionalService professionalService;

    @Override
    @Transactional
    public boolean createRequest(ServiceRequestDto dto) {
        try{
            Professional professional = professionalService.findById(dto.getProfessionalId());
            ServiceRequest request = new ServiceRequest();
            request.setCreatedAt(dto.getCreatedAt());
            request.setDescription(dto.getDescription());
            request.setProfessional(professional);
            request.setStatus(ServiceStatus.STARTED);
            request.setTitle(dto.getTitle());

            requestRepository.save(request);
            log.info("Service request creation completed successfully");
            return true;

        }catch(ProfessionalNotFoundException ex){
            log.error("Service request creation failed, the professional hasn't been found, id:{}", dto.getProfessionalId());
            return false;
        }
    }

    @Override
    public ServiceRequest findRequestById(Long id) {
        Optional<ServiceRequest> request = requestRepository.findById(id);
        return request.orElseThrow(()-> new ServiceRequestNotFound("The service request doesn't exits with the id:" + id));

    }

    @Override
    public List<ServiceRequest> findAllRequestByProfessionalId(Long professionalId) {
        if (professionalService.existsProfessionalById(professionalId)) {
            return requestRepository.findByProfessionalId(professionalId);
        }
        throw new ProfessionalNotFoundException("The professional with id " + professionalId + " doesn't exist");

    }

    @Override
    @Transactional
    public ServiceRequest updateRequest(ServiceRequestDto dto, Long id) {
        try{
            ServiceRequest request = findRequestById(id);
            Professional professional = professionalService.findById(dto.getProfessionalId());

            request.setCreatedAt(dto.getCreatedAt());
            request.setDescription(dto.getDescription());
            request.setProfessional(professional);
            //the part below need to be modified to control what kind of state can be sent from frontEnd
            //request.setState();
            request.setTitle(dto.getTitle());

            log.info("Service request updated, service request id: {}", id );
            return requestRepository.save(request);

        }catch(ProfessionalNotFoundException ex){
            log.error("service request update failed, the professional hasn't been found, professional id:{}", dto.getProfessionalId());
            throw ex;
        }catch(ServiceRequestNotFound ex){
            log.error("service request update failed, the service request with that id doesn't exists, request id:{} ", id);
            throw ex;
        }

    }

    @Override
    @Transactional
    public boolean deleteRequest(Long id) {
        if(requestRepository.existsById(id)){
            requestRepository.deleteById(id);
            log.info("Service request deleted completed");
            return true;
        }
        else{
            log.error("Service request deletion failed, doesn't exists any request with the id:{}", id);
            return false;
        }
    }
}
