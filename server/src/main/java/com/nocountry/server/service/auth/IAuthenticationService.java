package com.nocountry.server.service.auth;


import com.nocountry.server.model.dto.auth.AuthenticationRequest;
import com.nocountry.server.model.dto.auth.AuthenticationResponse;
import com.nocountry.server.model.dto.auth.UserRegistrationRequest;

public interface IAuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void signUp(UserRegistrationRequest request);
}
