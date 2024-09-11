package com.nocountry.server.model.mappers;

import com.nocountry.server.model.dto.UserDto;
import com.nocountry.server.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
