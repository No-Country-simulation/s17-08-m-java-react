package com.nocountry.server.model.mappers;

import com.nocountry.server.model.dto.ServiceRequestDto;
import com.nocountry.server.model.entity.ServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceRequestMapper {

    @Mapping(source = "professional.id", target = "professionalId")
    ServiceRequestDto toDto(ServiceRequest serviceRequest);

    @Mapping(source = "professionalId", target = "professional.id")
    ServiceRequest toEntity(ServiceRequestDto serviceRequestDto);
}
