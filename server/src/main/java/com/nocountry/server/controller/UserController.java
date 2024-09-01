package com.nocountry.server.controller;

import com.nocountry.server.exception.UserNotFoundException;
import com.nocountry.server.model.dto.UserDto;
import com.nocountry.server.model.entity.User;
import com.nocountry.server.service.impl.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arregloYa/v1/")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService service;

    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = service.findById(id);
            log.info("Successfully retrieved user with id: {}", id);
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (UserNotFoundException ex) {
            log.error("User not found, incorrect Id: {}", id);
            return new ResponseEntity<>("User not Found with that id", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("users")
    public ResponseEntity<?> listUsers(){
        List<User> list= service.getAllUser();
        return new ResponseEntity<>(list, HttpStatus.OK);

   }

    @PostMapping("user")
    public ResponseEntity<?> createUser(@RequestBody UserDto dto) {
        if (service.createUser(dto)) {
            log.info("User Created succesfully with the email : {}", dto.getEmail());
            return new ResponseEntity<>("User created successfully", HttpStatus.OK);
        }

        log.error("User already exists with the email: {}",dto.getEmail());
        return new ResponseEntity<>("the user with that email already exists", HttpStatus.BAD_REQUEST );

    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserDto dto, @PathVariable Long id){
        User user = service.updateUser(dto, id);
        if (user != null){
            log.info("The user was updated correctly using the id: {}", id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        //in other case
        log.error("The user with doesn't exists with the id {}:", id);
        return new ResponseEntity<>("The user with doesn't exists with the id " + id, HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        if(service.deleteUser(id)){
            log.info("User deleted with id: {}", id);
            return new ResponseEntity<>("User deleted correclty", HttpStatus.OK);
        }
        log.error("The user with doesn't exists with the id {}", id);
        return new ResponseEntity<>("Error deleting the user, doesn't exists any with the id: " + id, HttpStatus.BAD_REQUEST);
    }

}
