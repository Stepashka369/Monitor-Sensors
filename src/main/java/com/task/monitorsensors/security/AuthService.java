package com.task.monitorsensors.security;

import com.task.monitorsensors.entity.UserEntity;
import com.task.monitorsensors.exception.ElementAlreadyExistsException;
import com.task.monitorsensors.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class AuthService {
    private UserService userService;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UserService userService, JwtService jwtService,
                       PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse signUp(@Valid AuthRequest request) throws ElementAlreadyExistsException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(Role.ROLE_VIEWER);
        userService.save(userEntity);
        String jwt = jwtService.generateToken(userEntity);
        return new AuthResponse(jwt);
    }

    public AuthResponse signIn(@Valid AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()));
        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
}
