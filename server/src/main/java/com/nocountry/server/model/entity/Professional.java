package com.nocountry.server.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String experience;

    private String availavility;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
