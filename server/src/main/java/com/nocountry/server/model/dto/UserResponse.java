package com.nocountry.server.model.dto;

import java.io.Serializable;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String location,
        String urlImage
) implements Serializable {
}
