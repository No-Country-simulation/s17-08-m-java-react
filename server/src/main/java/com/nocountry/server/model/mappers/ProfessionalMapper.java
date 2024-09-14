package com.nocountry.server.model.mappers;

import com.nocountry.server.model.dto.ProfessionalUpdateRequest;
import com.nocountry.server.model.dto.ProfessionalResponse;
import com.nocountry.server.model.entity.Professional;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {IUserMapper.class})
public interface ProfessionalMapper {

    ProfessionalResponse toProfessionalResponse(Professional professional);

    void updateProfessionalFromRequest(ProfessionalUpdateRequest request, @MappingTarget Professional professional);
}
