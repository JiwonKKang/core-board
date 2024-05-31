package com.core.corebackboard.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Getter
@Component
public class JwtTokenUtil {

    private static String secretKey;

    private static Long expiredTimeMs;

    @Value("${jwt.token.secret-key}")
    public void setSecretKey(String secretKey) {
        JwtTokenUtil.secretKey = secretKey;
    }

    @Value("${jwt.token.expired-time-ms}")
    public void setExpiredTimeMs(Long expiredTimeMs) {
        JwtTokenUtil.expiredTimeMs = expiredTimeMs;
    }

    public static String generateAccessToken(String username) {
        Claims claims = Jwts.claims();
        claims.put("username", username);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredTimeMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static String getUsername(String token) {
        return extractAllClaims(token).get("username", String.class);
    }

    public static Boolean isTokenExpired(String token) {
        Date expiration = extractAllClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    private static Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private static Key getSigningKey() {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }




}
