package com.task.monitorsensors.security;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response to a registration or login request ")
public class AuthResponse {

    @Schema(description = "Jwt token for getting access to the controllers")
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
