package com.nocountry.server.controller;

import com.nocountry.server.exception.ServiceRequestNotFound;
import com.nocountry.server.model.dto.ServiceRequestDto;
import com.nocountry.server.model.entity.ServiceRequest;
import com.nocountry.server.service.IServiceRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arregloYa/v1/")
public class ServiceRequestController {
    private IServiceRequestService service;

    @Autowired
    public ServiceRequestController(IServiceRequestService service) {
        this.service = service;
    }

    @PostMapping("request-service")
    public ResponseEntity<?> createServiceRequest(@RequestBody @Valid ServiceRequestDto dto){
        if(service.createRequest(dto)){
            return new ResponseEntity<>("Service request created successfully", HttpStatus.OK);
        }else
            return new ResponseEntity<>("Service request failed, the professional with the id:"+ dto.getProfessionalId() + " doesn't exists", HttpStatus.BAD_REQUEST)

    }

    @GetMapping("request-service/{requestId}")
    public ResponseEntity<?> findRequestById(@PathVariable Long id){
        try{
            ServiceRequest request = service.findRequestById(id);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }catch(ServiceRequestNotFound ex){
            return new ResponseEntity<>("The request with the id:" + id + " doesn't exists", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("requests-service-by-professional/{professionalId}")
    public ResponseEntity<?> findAllServiceRequestByProfessionalId(@PathVariable Long professionalId){

    }

    @PutMapping("request-service/{requestId}")
    public ResponseEntity<?> updateRequestService(@RequestBody @Valid ServiceRequestDto dto,@PathVariable Long requestId){

    }

    @DeleteMapping("request-service/{requestId}")
    public ResponseEntity<?> deleteRequestService(@PathVariable Long requestId){

    }

}
