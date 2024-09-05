package com.nocountry.server.model.entity.state;

import com.nocountry.server.model.entity.ServiceRequest;

public class StartedState implements ServiceRequestState{
    @Override
    public void completeRequest(ServiceRequest request) {

    }

    @Override
    public void cancelRequest(ServiceRequest request) {

    }

    @Override
    public void pauseRequest(ServiceRequest request) {

    }

    @Override
    public void resumeRequest(ServiceRequest request) {

    }
}
