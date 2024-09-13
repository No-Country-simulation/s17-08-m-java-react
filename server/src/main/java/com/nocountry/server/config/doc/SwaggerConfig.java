package com.nocountry.server.config.doc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "ArregloYa API",
                description = "The backend of the ArregloYa project is responsible for handling all server-side operations.",
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        url = "http://localhost:9090/api/v1",
                        description = "DEV SERVER"
                ),
                @Server(
                        url = "https://s17-08-m-java-react.onrender.com/api/v1",
                        description = "PROD SERVER"
                )
        },
        security = @SecurityRequirement(name = "Security Token")
)
@SecurityScheme(
        name = "Security Token",
        description = "Access token for the API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT")
public class SwaggerConfig {
}
