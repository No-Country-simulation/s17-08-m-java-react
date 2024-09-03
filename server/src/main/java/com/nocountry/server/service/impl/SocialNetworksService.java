package com.nocountry.server.service.impl;

import com.nocountry.server.model.dto.SocialNetworkDto;
import com.nocountry.server.model.entity.SocialNetworks;
import com.nocountry.server.repository.SocialNetworksRepository;
import com.nocountry.server.service.ISocialNetworksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialNetworksService implements ISocialNetworksService {

    @Autowired
    private SocialNetworksRepository socialNetworksRepository;

    @Autowired
    private ProfessionalService professionalService;

    @Override
    public SocialNetworks createSocialNetworks(SocialNetworkDto dto) {
        SocialNetworks socialNetworks = new SocialNetworks();
        socialNetworks.setDescription(dto.getDescription());
        socialNetworks.setProfessional(professionalService.findById(dto.getProfessionalId()));

        socialNetworksRepository.save(socialNetworks);
        return socialNetworks;
    }


}
