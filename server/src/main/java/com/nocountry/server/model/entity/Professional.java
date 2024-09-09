package com.nocountry.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

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

    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialNetworks> socialNetworks; // añadí la relación no a muchos hacia SocialNetworks

    @ManyToMany(fetch =  FetchType.EAGER)
    @JoinTable(name = "professional_category",
            joinColumns = @JoinColumn( name= "professional_id"),
            inverseJoinColumns = @JoinColumn( name = "category_id"))
    private List<Category> categories;

    //fetch type 'eager' to get all works done until today
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    private List<ServiceRequest> requests;

}
