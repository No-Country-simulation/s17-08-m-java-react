package com.nocountry.server.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "professionals")
@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String experience;

    private String availability;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
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

    public int calculateAverageRating(){
        if(requests == null || requests.isEmpty()){
            //just to set an average
            return 3;
        }
        double  totalRatings = 0;

        for(ServiceRequest request : requests){
            totalRatings += request.getReference().getRating();
        }

        int average = (int) Math.round(totalRatings/requests.size());
        return average;
    }
}
