package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;

    @NotBlank
    private String description;
}
