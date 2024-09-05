package com.nocountry.server.model.entity;

import com.nocountry.server.model.entity.enums.ServiceStatus;
import com.nocountry.server.model.entity.state.ServiceRequestState;
import com.nocountry.server.model.entity.state.StartedState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Builder

@Entity
@Table(name = "services")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceStatus status;
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "request")
    @JoinColumn(name = "reference_id")
    private Reference reference;

    @ManyToOne
    @JoinColumn(name ="professional_id")
    private Professional professional;

    //by the moment it won't be persisted
    @Transient
    private ServiceRequestState state;

    public ServiceRequest() {
        this.state = new StartedState();
    }

    public  void completeRequest(){
        state.completeRequest(this);
    }

    public void cancelRequest(){
        state.cancelRequest(this);
    }

    public void pauseRequest(){
        state.pauseRequest(this);
    }
    public void resumeRequest(){
        state.resumeRequest(this);
    }


}
