package com.project.dasomapi.auth.usecase;

import com.project.dasomapi.auth.usecase.req.LoginReq;
import com.project.dasomapi.auth.usecase.req.ReissueReq;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.auth.application.PasswordEncoder;
import com.project.dasomcore.auth.application.dto.Token;
import com.project.dasomcore.auth.application.dto.res.ReissueRes;
import com.project.dasomcore.auth.domain.exception.ReissueTokenException;
import com.project.dasomcore.member.application.MemberService;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.member.domain.exception.WrongPasswordException;
import com.project.dasominfra.token.TokenExtractor;
import com.project.dasominfra.token.TokenIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AuthUseCase {
    private final PasswordEncoder encoder;
    private final MemberService memberService;
    private final TokenIssuer tokenIssuer;
    private final TokenExtractor tokenExtractor;

    public ResponseData<Token> login(LoginReq req){
        Member member = memberService.getByEmail(req.email());
        verifyPw(req.pw(),member.getPw());
        Token token = tokenIssuer.issueToken(req.email(), member.getRole());
        return ResponseData.ok("로그인 성공", token);
    }

    public ResponseData<ReissueRes> reissue(ReissueReq req){
        try{
            String email = tokenExtractor.getSubjectFromRefreshToken(req.refreshToken());
            Member member = memberService.getByEmail(email);
            final String accessToken = tokenIssuer.issueAccessToken(email, member.getRole());
            return ResponseData.ok("토큰 재발급 성공",new ReissueRes(accessToken));
        }catch(Exception e){
            throw new ReissueTokenException();
        }
    }

    private void verifyPw(String pw, String encodePw){
        if (!encoder.matches(pw, encodePw)) throw new WrongPasswordException();
    }
}
