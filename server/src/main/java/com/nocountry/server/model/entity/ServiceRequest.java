package com.nocountry.server.model.entity;

import com.nocountry.server.model.entity.enums.ServiceStatus;
import com.nocountry.server.model.entity.state.*;
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

    //this field doesn't need to be persisted
    @Transient
    private ServiceRequestState state;

    public ServiceRequest() {
        this.state = new StartedState();
    }
    //----------------------------------------state pattern applied----------------------------------
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

    //method to set the state obtained from the db
    public void loadState(){
        switch(this.getStatus()) {
            case STARTED :
                this.setState(new StartedState());
                break;

            case PAUSED:
                this.setState(new PausedState());
                break;

            case CANCELLED:
                this.setState(new CancelledState());
                break;

            case COMPLETED:
                this.setState(new CompletedState());
                break;
        }
    }
}
