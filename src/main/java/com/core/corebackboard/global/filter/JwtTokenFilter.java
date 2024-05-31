package com.core.corebackboard.global.filter;

import com.core.corebackboard.user.service.UserDomain;
import com.core.corebackboard.user.service.UserReader;
import com.core.corebackboard.util.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    final String BEARER = "Bearer ";
    private final UserReader userReader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null || !header.startsWith(BEARER)) {
            log.warn("Authorization Header does not start with Bearer");
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = header.replace(BEARER, "");

        if (JwtTokenUtil.isTokenExpired(accessToken)) {;
            log.warn("Token is expired");
            filterChain.doFilter(request, response);
            return;
        }

        String username = JwtTokenUtil.getUsername(accessToken);
        UserDomain user = userReader.readByName(username);

        saveAuthentication(user);

        filterChain.doFilter(request, response);
    }

    private void saveAuthentication(UserDomain user) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                user, null,
                null
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.info("{} 유저 인증 성공", user.info().name());
    }
}
