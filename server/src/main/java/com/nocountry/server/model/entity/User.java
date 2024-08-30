package com.nocountry.server.model.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    private String email;

    private String password;

    private String location;

    @Column(name = "url_image")
    private String urlImage;

    private boolean enabled;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @OneToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;








}
