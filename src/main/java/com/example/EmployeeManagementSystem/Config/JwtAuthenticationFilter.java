package com.example.EmployeeManagementSystem.Config;


import com.example.EmployeeManagementSystem.Service.UserService;
import com.example.EmployeeManagementSystem.Token.JwtService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if (StringUtils.isEmpty(authHeader) || !(authHeader.contains("Bearer ") )) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUserName(jwt);
        if (StringUtils.isNotEmpty(userEmail)
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userService.userDetailsService()
                    .loadUserByUsername(userEmail);
            if (jwtService.isTokenValid(jwt, userDetails)) {
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }
        }
        filterChain.doFilter(request, response);
    }
}





//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//

//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        final String requestTokenHeader = request.getHeader("Authorization");
//
//        final String jwt;
//        final String userEmail;
//
//       if (StringUtils.isEmpty(requestTokenHeader) || ! (requestTokenHeader.contains("Bearer "))){
//           filterChain.doFilter(request,response);
//           return;
//       }
//            jwtToken = requestTokenHeader.substring(7);
//            username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//
//
//        if (StringUtils.isNotEmpty(username)
//       && SecurityContextHolder.getContext().getAuthentication()== null) {
//            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//
//            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//       SecurityContext context = SecurityContextHolder.createEmptyContext();
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                        context.setAuthentication(usernamePasswordAuthenticationToken);
//                SecurityContextHolder.setContext(context);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }

//    @RestController
//    @RequestMapping("/api/deductions")
//    public static class DeductionController {
//
//        private final DeductionService deductionService;
//
//        @Autowired
//        public DeductionController(DeductionService deductionService) {
//            this.deductionService = deductionService;
//        }
//
//        @GetMapping("/fixed")
//        public CompanyDeductions getFixedDeduction(){
//            return deductionService.getFixedDeduction();
//        }
//        @GetMapping
//        public List<CompanyDeductions> getAllCompanyDeductions() {
//            return deductionService.getAllCompanyDeductions();
//        }
//
//        @GetMapping("/{id}")
//        public Optional<CompanyDeductions> getCompanyDeductionById(@PathVariable Long id) {
//            return deductionService.getCompanyDeductionById(id);
//        }
//        @PostMapping
//        public CompanyDeductions createDeduction(@RequestBody CompanyDeductions companyDeductions) {
//            return deductionService.createCompanyDeduction(companyDeductions);
//        }
//
//        @PutMapping("/{id}")
//        public CompanyDeductions updateCompanyDeduction(@PathVariable Long id, @RequestBody CompanyDeductions companyDeductions) {
//            return deductionService.updateCompanyDeduction(id, companyDeductions);
//        }
//
//        @DeleteMapping("/{id}")
//        public void deleteCompanyDeductions(@PathVariable Long id) {
//            deductionService.deleteCompanyDeductions(id);
//        }
//    }
//}