package com.nocountry.server.controller;

import com.nocountry.server.exception.ProfessionalNotFoundException;
import com.nocountry.server.exception.ServiceRequestNotFound;
import com.nocountry.server.model.dto.ServiceRequestDto;
import com.nocountry.server.model.entity.ServiceRequest;
import com.nocountry.server.service.IServiceRequestService;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Service Requests")
@RequiredArgsConstructor
@RestController
@RequestMapping("/request-services")
public class ServiceRequestController {
    private final IServiceRequestService service;

    @PostMapping
    public ResponseEntity<?> createServiceRequest(@RequestBody @Valid ServiceRequestDto dto){
        if(service.createRequest(dto)){
            return new ResponseEntity<>("Service request created successfully", HttpStatus.OK);
        }else
            return new ResponseEntity<>("Service request failed, the professional with the id:"+ dto.getProfessionalId() + " doesn't exists", HttpStatus.BAD_REQUEST);

    }

    @SecurityRequirements
    @GetMapping("/{requestId}")
    public ResponseEntity<?> findRequestById(@PathVariable Long id){
        try{
            ServiceRequest request = service.findRequestById(id);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }catch(ServiceRequestNotFound ex){
            return new ResponseEntity<>("The request with the id:" + id + " doesn't exists", HttpStatus.BAD_REQUEST);
        }
    }

    @SecurityRequirements
    @GetMapping("requests-service-by-professional/{professionalId}")
    public ResponseEntity<?> findAllServiceRequestByProfessionalId(@PathVariable Long professionalId){
        try{
            List<ServiceRequest> list = service.findAllRequestByProfessionalId(professionalId);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch(ProfessionalNotFoundException ex){
            return new ResponseEntity<>("The professional with id " + professionalId + " doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<?> updateRequestService(@RequestBody @Valid ServiceRequestDto dto,@PathVariable Long requestId){
        try{
            ServiceRequest request = service.updateRequest(dto, requestId);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }catch(ProfessionalNotFoundException ex){
            return new ResponseEntity<>("The professional with id " + dto.getProfessionalId() + " doesn't exist", HttpStatus.BAD_REQUEST);
        }catch(ServiceRequestNotFound ex){
            return new ResponseEntity<>("The Service Request with id " + requestId + " doesn't exist", HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<?> deleteRequestService(@PathVariable Long requestId){
        if(service.deleteRequest(requestId)){
            return new ResponseEntity<>("Service request deleted successfully", HttpStatus.OK);
        }
            return new ResponseEntity<>("The Service Request with id " + requestId + " doesn't exist", HttpStatus.BAD_REQUEST);
    }

}
