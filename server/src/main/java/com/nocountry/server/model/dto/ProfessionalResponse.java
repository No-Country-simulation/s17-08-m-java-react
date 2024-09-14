package com.nocountry.server.model.dto;

import java.io.Serializable;
import java.util.List;

public record ProfessionalResponse(
        Long id,
        String description,
        String availability,
        String experience,
        UserResponse user,
        List<SocialNetworkDto> socialNetworks,
        List<CategoryDTO> categories,
        List<ServiceRequestDto> requests

) implements Serializable {}
