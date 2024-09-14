package com.nocountry.server.service.auth.impl;

import com.nocountry.server.exception.*;
import com.nocountry.server.model.mappers.IUserMapper;
import com.nocountry.server.model.dto.auth.AuthenticationRequest;
import com.nocountry.server.model.dto.auth.AuthenticationResponse;
import com.nocountry.server.model.dto.auth.UserRegistrationRequest;
import com.nocountry.server.model.entity.Professional;
import com.nocountry.server.model.entity.Role;
import com.nocountry.server.model.entity.Token;
import com.nocountry.server.model.entity.User;
import com.nocountry.server.model.entity.enums.RoleEnum;
import com.nocountry.server.repository.ProfessionalRepository;
import com.nocountry.server.repository.RoleRepository;
import com.nocountry.server.repository.TokenRepository;
import com.nocountry.server.repository.UserRepository;
import com.nocountry.server.service.auth.IAuthenticationService;
import com.nocountry.server.service.email.ISendEmailService;
import com.nocountry.server.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final ProfessionalRepository professionalRepository;
    private final RoleRepository roleRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserMapper userMapper;
    private final ISendEmailService email;

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

    @Transactional
    @Override
    public void signUp(UserRegistrationRequest request) {
        String role = validateRole(request.role());
        existEmailThrow(request);

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        assignRolesToUser(role, user);
        email.sendValidationEmail(user);
    }

    @Override
    public void activateAccount(String token) {
        Token savedToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new TokenInvalidException("invalid token"));

        if(LocalDateTime.now().isAfter(savedToken.getExpiredAt())) {
            email.sendValidationEmail(savedToken.getUser());
            throw new TokenInvalidException("Activation token has expired. A new token has been sent to your email.");
        }

        User user = savedToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);

        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);
    }

    private void assignRolesToUser(String role, User user) {
        if (role.equals(RoleEnum.CLIENT.name())) {
            Set<Role> userRoles = getRolesDataBaseOrThrow(List.of(RoleEnum.CLIENT.name()));
            user.setRoles(userRoles);
            userRepository.save(user);
        } else if (role.equals(RoleEnum.PROFESSIONAL.name())) {
            Set<Role> userRoles = getRolesDataBaseOrThrow(List.of(RoleEnum.CLIENT.name(), RoleEnum.PROFESSIONAL.name()));
            user.setRoles(userRoles);

            Professional professional = Professional.builder().user(user).build();
            professionalRepository.save(professional);
        }
    }

    private String validateRole(String role) {
        if (!role.equalsIgnoreCase(RoleEnum.CLIENT.name()) && !role.equalsIgnoreCase(RoleEnum.PROFESSIONAL.name())) {
            throw new RoleInvalidException("invalid role");
        }
        return role.toUpperCase();
    }

    private Set<Role> getRolesDataBaseOrThrow(List<String> roles) {
        Set<Role> userRoles = new HashSet<>(roleRepository.findRolesByRoleEnumIn(roles));
        if (userRoles.isEmpty()) {
            throw new RoleNotFoundException("Role not found");
        }
        return userRoles;
    }

    private void existEmailThrow(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistException("Email already exists");
        }
    }
}