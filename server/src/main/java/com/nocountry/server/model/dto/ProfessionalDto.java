package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessionalDto {

    @NotBlank
    private String description;

    private String experience;

    private String availavility;

    @NotBlank
    private Long userId;
}
