package com.nocountry.server.mappers;

import com.nocountry.server.model.dto.auth.UserRegistrationRequest;
import com.nocountry.server.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper {

    User toUser(UserRegistrationRequest request);
}
