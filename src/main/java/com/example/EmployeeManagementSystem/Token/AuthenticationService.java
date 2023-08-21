package com.example.EmployeeManagementSystem.Token;

import com.example.EmployeeManagementSystem.dto.SignInRequest;
import com.example.EmployeeManagementSystem.dto.SignUpRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse signUp(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);
}
