package com.nocountry.server.model.entity.state;

import com.nocountry.server.model.entity.ServiceRequest;

public interface ServiceRequestState {
    void completeRequest(ServiceRequest request);
    void cancelRequest(ServiceRequest request);
    void pauseRequest(ServiceRequest request);
    void resumeRequest(ServiceRequest request);

}
