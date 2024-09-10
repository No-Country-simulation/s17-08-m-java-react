package com.nocountry.server.model.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record UserRegistrationRequest(

        @Size(min = 2, message = "First name should be 2 characters long minimum")
        @Size(max = 50, message = "First name should be 50 characters long maximum")
        @NotBlank(message = "First name is mandatory")
        String firstName,

        @Size(min = 2, message = "Last name should be 2 characters long minimum")
        @Size(max = 50, message = "Last name should be 50 characters long maximum")
        @NotBlank(message = "Last name is mandatory")
        String lastName,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email is not formatted")
        String email,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password should be 8 characters long minimum")
        @Size(max = 15, message = "Password should be 15 characters long maximum")
        String password,

        String role

) implements Serializable {

    public UserRegistrationRequest {
        if (role == null) {
            role = "CLIENT";
        }
    }
}
