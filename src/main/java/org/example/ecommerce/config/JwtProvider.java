package org.example.ecommerce.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {
    public String generateToken(Authentication authentication) {
        SecretKey key = Keys.hmacShaKeyFor(JwtConst.SECRET.getBytes());

        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 840000000))
                .claim("email", authentication.getName())
                .signWith(key)
                .compact();
        return jwt;
    }

    public String getEmailFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(JwtConst.SECRET.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("email", String.class); // Extract the "email" claim
    }
}
