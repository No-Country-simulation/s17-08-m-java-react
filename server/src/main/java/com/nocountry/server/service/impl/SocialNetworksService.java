package com.nocountry.server.service.impl;

import com.nocountry.server.model.dto.SocialNetworkDto;
import com.nocountry.server.model.entity.SocialNetworks;
import com.nocountry.server.repository.ProfessionalRepository;
import com.nocountry.server.repository.SocialNetworksRepository;
import com.nocountry.server.service.ISocialNetworksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SocialNetworksService implements ISocialNetworksService {

    private final SocialNetworksRepository socialNetworksRepository;
    private final ProfessionalRepository professionalRepository;

    @Override
    public SocialNetworks createSocialNetworks(SocialNetworkDto dto) {
        SocialNetworks socialNetworks = new SocialNetworks();
        socialNetworks.setDescription(dto.getDescription());
        socialNetworks.setProfessional(professionalRepository.findById(dto.getProfessionalId()).orElseThrow());

        socialNetworksRepository.save(socialNetworks);
        return socialNetworks;
    }


}
