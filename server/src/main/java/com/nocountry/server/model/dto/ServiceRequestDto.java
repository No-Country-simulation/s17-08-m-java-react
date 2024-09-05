package com.nocountry.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class ServiceRequestDto {

    @NotBlank
    private String title;
    private String description;
    private LocalDateTime createdAt;
    @NotBlank
    private Long professionalId;

    //for future usages there will be needed the user id
    //@NotBlank
    //private Long userId



}
