package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class ServiceRequestDto {

    @NotBlank(message = "The title can't be blank")
    private String title;

    @NotBlank(message = "A brief description of the problem is required")
    @Size(min = 10, message = "the description must be at least 10 characters ")
    private String description;

    private LocalDateTime createdAt;

    @NotBlank(message = "The professional id is mandatory")
    private Long professionalId;

    //for future usages there will be needed the user id
    //@NotBlank
    //private Long userId



}
