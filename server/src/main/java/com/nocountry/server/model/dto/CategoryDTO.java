package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CategoryDTO implements Serializable {

    @NotBlank(message = "The category id is mandatory")
    private Long id;

    @NotBlank(message = "The description can't be blank")
    private String description;
}
