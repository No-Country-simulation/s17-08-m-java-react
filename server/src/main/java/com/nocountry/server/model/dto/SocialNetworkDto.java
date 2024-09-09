package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialNetworkDto {

    @NotBlank(message = "The description can't be blank")
    private String description;

    @NotBlank(message = "The professional id is mandatory")
    private Long professionalId;
}
