package com.nocountry.server.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "first name can't be blank")
    private String firstName;

    @NotBlank(message = "last name can't be blank")
    private String lastName;

    @NotBlank(message = "The email can't be blank")
    @Email(message = "The value should be an email format")
    private String email;

    @NotBlank(message = "the password can't be blank")
    private String password;

    private String location;

    private String urlImage;

}
