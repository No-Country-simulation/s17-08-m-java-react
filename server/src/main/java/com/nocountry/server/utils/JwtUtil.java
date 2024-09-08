package com.nocountry.server.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.nocountry.server.model.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtUtil {

    @Value("${security.jwt.secret-key}")
    private String secretKey;
    @Value("${security.jwt.issuer}")
    private String issuer;
    @Value("${security.jwt.expiration}")
    private Long jwtExpiration;

    public String createToken(Authentication authentication) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        User user = (User) authentication.getPrincipal();
        String username = user.getEmail();

        List<String> authorities = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .toList();

        return JWT.create()
                .withIssuer(issuer)
                .withClaim("fullName", user.fullName())
                .withSubject(username)
                .withClaim("authorities", authorities)
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtExpiration))
                .withNotBefore(new Date(System.currentTimeMillis()))
                .withJWTId(UUID.randomUUID().toString())
                .sign(algorithm);
    }

    public DecodedJWT validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();

            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Token is invalid");
        }
    }

    public String extractUsername(String token) {
        return validateToken(token).getSubject();
    }

    public Claim extractClaim(String token, String claim) {
        return validateToken(token).getClaim(claim);
    }

    public Map<String, Claim> extractAllClaims(String token) {
        return validateToken(token).getClaims();
    }
}
