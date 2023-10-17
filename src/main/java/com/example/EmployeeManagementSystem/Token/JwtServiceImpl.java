//package com.example.EmployeeManagementSystem.Token;
//
//import com.example.EmployeeManagementSystem.Service.JwtService;
//import io.jsonwebtoken.Claims;
//
//import java.io.Serializable;
//import java.lang.String;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.cglib.core.internal.Function;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class JwtServiceImpl implements JwtService {
//
//    @Override
//    public String extractUserName(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    @Override
//    public String generateToken(UserDetails userDetails) {
//        return generateTokens(new HashMap<>(), userDetails);
//    }
//
//    @Override
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        final String userName = extractUserName(token);
//        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
//    }
//
//    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolvers.apply(claims);
//    }
//
//    private String generateTokens(Map<String, Object> extraClaims, UserDetails userDetails) {
//        Date now = new Date();
//        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(now.getTime()))
//                .setExpiration(new Date(now.getTime() + 1000 * 60 * 60))
//                .signWith(SignatureAlgorithm.HS256,("B374A26A71490437AA024E4FADD5B497FDFF1A8EA6FF12F6FB65AF2720B59CCF")
//                        .getBytes(StandardCharsets.UTF_8)).compact();
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parserBuilder().setSigningKey(("B374A26A71490437AA024E4FADD5B497FDFF1A8EA6FF12F6FB65AF2720B59CCF")
//                .getBytes(StandardCharsets.UTF_8)).build().parseClaimsJws(token).getBody();
//    }
//
//}