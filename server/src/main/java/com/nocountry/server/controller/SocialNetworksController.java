package com.nocountry.server.controller;


import com.nocountry.server.model.dto.SocialNetworkDto;
import com.nocountry.server.model.entity.SocialNetworks;
import com.nocountry.server.service.impl.SocialNetworksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialNetworks")
public class SocialNetworksController {

    @Autowired
    private SocialNetworksService socialNetworksService;

    @PostMapping("/new")
    public SocialNetworks create(@RequestBody SocialNetworkDto dto) {
        return socialNetworksService.createSocialNetworks(dto);
    }


}
