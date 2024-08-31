package com.nocountry.server.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
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

    public Professional(String experience, String description, User user, String availavility) {
        this.experience = experience;
        this.description = description;
        this.user = user;
        this.availavility = availavility;
    }
}
