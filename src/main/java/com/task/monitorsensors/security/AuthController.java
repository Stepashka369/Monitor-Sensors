//package com.task.monitorsensors.security;
//
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/authentication")
//public class AuthController {
//
//    private AuthenticationService authenticationService;
//
//    @Autowired
//    public AuthController(AuthenticationService authenticationService){
//        this.authenticationService = authenticationService;
//    }
//
//    @PostMapping("/sign-up")
//    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody @Valid SignUpRequest request) throws UserAlreadyExistsException, NotFoundException, AccountActivationException {
//        return new ResponseEntity<>(authenticationService.signUp(request), HttpStatus.OK);
//    }
//
//    @PostMapping("/sign-in")
//    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody @Valid SignInRequest request) {
//        return new ResponseEntity<>(authenticationService.signIn(request), HttpStatus.OK);
//    }
//
//    @PostMapping("/activation")
//    public ResponseEntity<Void> sendVerificationCode(@RequestBody @Valid ActivationCodeRequest request){
//        authenticationService.bindVerificationCode(request);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
