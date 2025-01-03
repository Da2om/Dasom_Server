package com.project.dasominfra.token;

import com.project.dasomcore.common.exception.GlobalExceptionCode;
import com.project.dasominfra.security.ErrorResponseSender;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenExceptionFilter extends OncePerRequestFilter {
    private final ErrorResponseSender errorResponseSender;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            errorResponseSender.send(response, GlobalExceptionCode.TOKEN_EXPIRED);
        } catch (MalformedJwtException e) {
            errorResponseSender.send(response, GlobalExceptionCode.MALFORMED_JWT);
        } catch (UnsupportedJwtException e) {
            errorResponseSender.send(response, GlobalExceptionCode.UNSUPPORTED_JWT);
        } catch (IllegalArgumentException e) {
            errorResponseSender.send(response, GlobalExceptionCode.ILLEGAL_ARGUMENT);
        }
    }
}
