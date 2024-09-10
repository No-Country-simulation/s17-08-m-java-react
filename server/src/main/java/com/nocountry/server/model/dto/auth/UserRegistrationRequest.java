package com.nocountry.server.model.dto.auth;

import java.io.Serializable;

public record UserRegistrationRequest(

        String firstName,
        String lastName,
        String email,
        String password,
        String role

) implements Serializable {
}
