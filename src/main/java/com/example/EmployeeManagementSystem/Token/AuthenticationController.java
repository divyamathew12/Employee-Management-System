//package com.example.EmployeeManagementSystem.Token;
//
//import com.example.EmployeeManagementSystem.dto.SignInRequest;
//import com.example.EmployeeManagementSystem.dto.SignUpRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
//public class AuthenticationController {
//
//    @Autowired
//    AuthenticationService authenticationService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest signUpRequest) {
//        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest) {
//        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
//    }
//}


