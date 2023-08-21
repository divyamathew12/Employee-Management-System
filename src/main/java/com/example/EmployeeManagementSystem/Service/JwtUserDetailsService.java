package com.example.EmployeeManagementSystem.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("USERNAME".equals(username)) {
//            return new User("USERNAME", "$2a$10$s1YQmyNdGzTn7ZLBXBChF0C9f6kFjAqPhccnP6Dx1WXx21Pk1C3G6", new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }
//}

