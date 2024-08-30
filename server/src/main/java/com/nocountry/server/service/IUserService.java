package com.nocountry.server.service;

import com.nocountry.server.model.dto.UserDto;
import com.nocountry.server.model.entity.User;

import java.util.List;

public interface IUserService {

    User findById(Long id);

    List<User> getAllUser();

    void createUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(Long id);

}
