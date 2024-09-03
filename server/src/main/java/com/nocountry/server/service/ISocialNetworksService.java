package com.nocountry.server.service;

import com.nocountry.server.model.dto.SocialNetworkDto;
import com.nocountry.server.model.entity.SocialNetworks;

public interface ISocialNetworksService {
    SocialNetworks createSocialNetworks(SocialNetworkDto dto);
}
