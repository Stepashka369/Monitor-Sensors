package com.task.monitorsensors.security;

import com.task.monitorsensors.exception.ElementAlreadyExistsException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@Tag(name = "Authentication controller", description = "Perform sign in and sign up operations")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    public ResponseEntity<AuthResponse> signUp(@RequestBody AuthRequest request) throws ElementAlreadyExistsException {
        return new ResponseEntity<>(authService.signUp(request), HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> signIn(@RequestBody AuthRequest request) {
        return new ResponseEntity<>(authService.signIn(request), HttpStatus.OK);
    }
}
