package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    @NotBlank(message = "The category id is mandatory")
    private Long id;

    @NotBlank(message = "The description can't be blank")
    private String description;
}
