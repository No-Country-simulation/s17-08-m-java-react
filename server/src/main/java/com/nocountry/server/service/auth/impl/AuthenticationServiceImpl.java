package com.nocountry.server.service.auth.impl;

import com.nocountry.server.model.dto.auth.AuthenticationRequest;
import com.nocountry.server.model.dto.auth.AuthenticationResponse;
import com.nocountry.server.service.auth.IAuthenticationService;
import com.nocountry.server.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                ));

        String token = jwtUtil.createToken(auth);
        return AuthenticationResponse.builder().token(token).build();
    }
}
