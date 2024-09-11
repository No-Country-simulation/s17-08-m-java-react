package com.nocountry.server.controller;

import com.nocountry.server.model.dto.auth.AuthenticationRequest;
import com.nocountry.server.model.dto.auth.AuthenticationResponse;
import com.nocountry.server.model.dto.auth.UserRegistrationRequest;
import com.nocountry.server.service.auth.IAuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final IAuthenticationService authService;

    @Operation(
            description = "Log in to the system",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User authenticated successfully",
                            content = @Content(schema = @Schema(implementation = AuthenticationResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request body",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "username or password is incorrect.",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Your account is disabled.",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "423",
                            description = "Your account is locked.",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unexpected error has occurred. We are working to resolve the problem.",
                            content = {@Content}
                    )
            }
    )
    @SecurityRequirements
    @PostMapping("/log-in")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @Operation(
            description = "Register a new user, if the role is not provided, the default role is CLIENT",
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "User registered successfully waiting for account validation",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request body, or email already exists or invalid role",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Role not found",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unexpected error has occurred. We are working to resolve the problem.",
                            content = {@Content}
                    )
            }
    )
    @SecurityRequirements
    @PostMapping("/sign-up")
    public ResponseEntity<Void> register(@RequestBody @Valid UserRegistrationRequest request) {
        authService.signUp(request);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            description = "Validate the account",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Account validated successfully",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid token or token expired",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unexpected error has occurred. We are working to resolve the problem.",
                            content = {@Content}
                    )
            },
            parameters = {
                    @Parameter(
                            name = "token",
                            description = "The token to validate the account, sent to the user's email",
                            required = true,
                            example = "145284")
            }
    )
    @SecurityRequirements
    @PostMapping("validate-account")
    public ResponseEntity<Void> validateAccount(@RequestParam String token) {
        authService.activateAccount(token);
        return ResponseEntity.ok().build();
    }
}
