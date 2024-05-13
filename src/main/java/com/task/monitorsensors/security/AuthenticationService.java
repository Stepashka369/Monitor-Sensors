package com.task.monitorsensors.security;

import com.stepashka.hibernate.dto.ActivationCodeDTO;
import com.stepashka.hibernate.entity.ActivationCodeEntity;
import com.stepashka.hibernate.entity.UserEntity;
import com.stepashka.hibernate.exception.AccountActivationException;
import com.stepashka.hibernate.exception.NotFoundException;
import com.stepashka.hibernate.exception.UserAlreadyExistsException;
import com.stepashka.hibernate.mail.MailService;
import com.stepashka.hibernate.repository.ActivationCodeRepository;
import com.stepashka.hibernate.service.impl.ActivationCodeService;
import com.stepashka.hibernate.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class AuthenticationService {
    private UserService userService;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(UserService userService,JwtService jwtService,
                                 PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager){
        this.userService = userService;
        this.activationCodeService = activationCodeService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.mailService = mailService;
    }

    public JwtAuthenticationResponse signUp(SignUpRequest request) throws UserAlreadyExistsException, NotFoundException, AccountActivationException {
        checkVerificationCode(request);
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(Role.ROLE_USER);
        userService.create(userEntity);
        var jwt = jwtService.generateToken(userEntity);
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getEmail());
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
