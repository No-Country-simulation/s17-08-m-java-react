package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessionalDto {
    @NotBlank(message = "the professional id is mandatory")
    private Long id;

    @NotBlank(message = "The description can't be blank")
    private String description;

    private String experience;

    private String availability;

    @NotBlank(message = "the user id is mandatory")
    private Long userId;
}
