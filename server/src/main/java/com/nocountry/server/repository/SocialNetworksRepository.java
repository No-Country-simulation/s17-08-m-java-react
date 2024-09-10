package com.nocountry.server.repository;

import com.nocountry.server.model.entity.SocialNetworks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworksRepository extends JpaRepository<SocialNetworks, Long> {
}
