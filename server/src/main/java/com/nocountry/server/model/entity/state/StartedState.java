package com.nocountry.server.model.entity.state;

import com.nocountry.server.model.entity.ServiceRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartedState implements ServiceRequestState{
    @Override
    public void completeRequest(ServiceRequest request) {
        log.info("The service request has been completed!, service request id: {}", request.getId());
        request.setState(new CompletedState());
    }

    @Override
    public void cancelRequest(ServiceRequest request) {
        log.info("service request cancelled, id: {}", request.getId());
        request.setState(new CancelledState());
    }

    @Override
    public void pauseRequest(ServiceRequest request) {
        log.info("service request paused, id{}", request.getId());
        request.setState(new PausedState());
    }

    @Override
    public void resumeRequest(ServiceRequest request) {
        System.out.println("the request isn't paused");
    }
}
