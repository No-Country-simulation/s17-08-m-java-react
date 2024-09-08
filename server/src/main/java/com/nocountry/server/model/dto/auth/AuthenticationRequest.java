package com.nocountry.server.model.dto.auth;

import java.io.Serializable;

public record AuthenticationRequest(
        String username,
        String password
) implements Serializable {
}
