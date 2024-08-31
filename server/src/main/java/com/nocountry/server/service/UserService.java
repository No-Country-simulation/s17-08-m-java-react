package com.nocountry.server.service;

import com.nocountry.server.model.dto.UserDto;
import com.nocountry.server.model.entity.User;
import com.nocountry.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;


    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = new User();
        user.setAccountLocked(false);
        user.setEnabled(true);
        user.setEmail(userDto.getEmail());
        user.setLocation(userDto.getLocation());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUrlImage(userDto.getUrlImage());

        repository.save(user);
    }

    @Override
    public void updateUser(UserDto userDto) {

        User user = new User();
        user.setAccountLocked(false);
        user.setEnabled(true);
        user.setEmail(userDto.getEmail());
        user.setLocation(userDto.getLocation());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUrlImage(userDto.getUrlImage());

        repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
