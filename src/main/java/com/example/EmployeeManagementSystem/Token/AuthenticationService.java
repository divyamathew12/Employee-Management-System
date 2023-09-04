package com.example.EmployeeManagementSystem.Token;


import com.example.EmployeeManagementSystem.dto.SignInRequest;
import com.example.EmployeeManagementSystem.dto.SignUpRequest;
import org.springframework.stereotype.Service;


@Service
public interface AuthenticationService {

    JwtAuthenticationResponse signIn(SignInRequest signInRequest);

    JwtAuthenticationResponse signUp(SignUpRequest signUpRequest);


}
