package com.nocountry.server.controller;

import com.nocountry.server.model.dto.auth.AuthenticationRequest;
import com.nocountry.server.model.dto.auth.AuthenticationResponse;
import com.nocountry.server.model.dto.auth.UserRegistrationRequest;
import com.nocountry.server.service.auth.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final IAuthenticationService authService;

    @PostMapping("/log-in")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Void> register(@RequestBody UserRegistrationRequest request) {
        authService.signUp(request);
        return ResponseEntity.status(201).build();
    }
}
