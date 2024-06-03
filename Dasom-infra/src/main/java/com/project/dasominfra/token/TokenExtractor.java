package com.project.dasominfra.token;

import com.project.dasomcore.member.application.MemberService;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasominfra.security.MemberDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class TokenExtractor {
    private final TokenProperties tokenProperties;
    private final MemberService memberService;

    public Authentication getAuthentication(String accessToken) {
        Claims claims = getClaims(accessToken);
        Member member = memberService.getByEmail(claims.getSubject());
        MemberDetails details = new MemberDetails(member);
        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
    }


    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(tokenProperties.getSecretKey())
                .build().parseClaimsJws(token).getBody();
    }

    public String getSubjectFromRefreshToken(String refreshToken){
        final Claims claims = getClaims(refreshToken);
        return claims.getSubject();
    }
}
