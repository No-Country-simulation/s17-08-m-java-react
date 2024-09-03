package com.nocountry.server.service.impl;

import com.nocountry.server.exception.UserNotFoundException;
import com.nocountry.server.model.dto.UserDto;
import com.nocountry.server.model.entity.User;
import com.nocountry.server.repository.UserRepository;
import com.nocountry.server.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;

    @Override
    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        //if the user doesn't exist then generate an exception
        return user.orElseThrow(()-> new UserNotFoundException("The user with that id doesn't exists") );

    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public boolean createUser(UserDto userDto) {
        if(!repository.existsByEmail(userDto.getEmail())){
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
            return true;
        }
            return false;

    }

    @Override
    public User updateUser(UserDto userDto, Long id) {
        try{
            User user = findById(id);
            user.setAccountLocked(false);
            user.setEnabled(true);
            user.setEmail(userDto.getEmail());
            user.setLocation(userDto.getLocation());
            user.setPassword(userDto.getPassword());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setUrlImage(userDto.getUrlImage());
            //updating the user
            repository.save(user);

            return user;
        }catch(UserNotFoundException ex){
            //user doesn't exist, send null instead
            return null;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
