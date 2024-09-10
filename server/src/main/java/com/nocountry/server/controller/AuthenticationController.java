package com.nocountry.server.controller;

import com.nocountry.server.model.dto.auth.AuthenticationRequest;
import com.nocountry.server.model.dto.auth.AuthenticationResponse;
import com.nocountry.server.model.dto.auth.UserRegistrationRequest;
import com.nocountry.server.service.auth.IAuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final IAuthenticationService authService;

    @SecurityRequirements
    @PostMapping("/log-in")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @SecurityRequirements
    @PostMapping("/sign-up")
    public ResponseEntity<Void> register(@RequestBody @Valid UserRegistrationRequest request) {
        authService.signUp(request);
        return ResponseEntity.status(201).build();
    }

    @SecurityRequirements
    @PostMapping("validate-account")
    public ResponseEntity<Void> validateAccount(@RequestParam String token) {
        authService.activateAccount(token);
        return ResponseEntity.ok().build();
    }
}
