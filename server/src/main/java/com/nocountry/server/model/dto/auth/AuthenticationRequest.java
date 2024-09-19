package com.nocountry.server.model.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record AuthenticationRequest(

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email is not formatted")
        String username,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password should be 8 characters long minimum")
        @Size(max = 15, message = "Password should be 15 characters long maximum")
        String password

) implements Serializable {
}
