package com.example.EmployeeManagementSystem.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtServiceImpl jwtTokenUtil;
//
//
//    @PostMapping(value = "/authenticate")
//    public ResponseEntity<AuthenticateResponseDto> createAuthenticationToken(@RequestBody AuthenticationRequestDto authenticationRequest) throws Exception {
//
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        final String token = jwtTokenUtil.generateToken(authenticationRequest.getUsername());
//
//        return ResponseEntity.ok(new AuthenticateResponseDto(token));
//    }
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
}

