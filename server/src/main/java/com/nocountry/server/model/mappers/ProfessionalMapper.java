package com.nocountry.server.model.mappers;

import com.nocountry.server.model.dto.ProfessionalDto;
import com.nocountry.server.model.entity.Professional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper {

    @Mapping(source = "user.id", target = "userId")
    ProfessionalDto toDto(Professional professional);

    @Mapping(source = "userId", target = "user.id")
    ProfessionalDto toEntity(ProfessionalDto professionalDto);

}
