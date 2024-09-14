package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessionalUpdateRequest(
        String urlImage,

        @NotBlank(message = "The description can't be blank")
        @Size(min = 10, message = "The description must be at least 10 characters")
        @Size(max = 255, message = "The description must be at most 255 characters")
        String description,

        @Size(max = 25, message = "The location must be at most 25 characters")
        @NotBlank(message = "The location can't be blank")
        String location,

        @Size(max = 15, message = "The experience must be at most 15 characters")
        @Size(min = 5, message = "The experience must be at least 5 characters")
        @NotBlank(message = "The experience can't be blank")
        String experience,

        @Size(max = 15, message = "The availability must be at most 15 characters")
        @NotBlank(message = "The availability can't be blank")
        String availability,

        @NotBlank(message = "The category id is mandatory")
        Long categoryId
) {
}
