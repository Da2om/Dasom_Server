package com.project.dasominfra.token;

import com.project.dasomcore.auth.application.dto.Token;
import com.project.dasomcore.member.domain.consts.MemberRole;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class TokenIssuer {
    private final TokenProperties tokenProperties;

    public Token issueToken(String username, final MemberRole role) {
        return new Token(issueAccessToken(username,role), issueRefreshToken(username,role));
    }

    public String issueAccessToken(String username, final MemberRole role) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, "ACCESS")
                .setSubject(username)
                .claim(tokenProperties.getHeader(), role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenProperties.getAccessExp()))
                .signWith(SignatureAlgorithm.HS512, tokenProperties.getSecretKey())
                .compact();
    }

    private String issueRefreshToken(String username, final MemberRole role) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, "REFRESH")
                .claim(tokenProperties.getHeader(), role)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenProperties.getRefreshExp()))
                .signWith(SignatureAlgorithm.HS512, tokenProperties.getSecretKey())
                .compact();
    }
}
