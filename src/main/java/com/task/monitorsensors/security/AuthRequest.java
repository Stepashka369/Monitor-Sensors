package com.task.monitorsensors.security;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Request for registration in service")
public class AuthRequest {

    @NotNull
    @Size(min = 1, max = 40)
    @Schema(description = "Username to be stored in database")
    private String username;

    @NotNull
    @Size(min = 1, max = 60)
    @Schema(description = "Associated with username password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
