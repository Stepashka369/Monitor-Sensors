package com.task.monitorsensors.security;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthRequest {

    @NotNull
    @Size(min = 1, max = 40)
    private String username;

    @NotNull
    @Size(min = 1, max = 60)
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
