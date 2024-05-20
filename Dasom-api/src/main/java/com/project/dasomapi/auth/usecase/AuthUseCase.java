package com.project.dasomapi.auth.usecase;

import com.project.dasomapi.auth.usecase.req.LoginReq;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.auth.application.PasswordEncoder;
import com.project.dasomcore.auth.application.dto.Token;
import com.project.dasomcore.member.application.MemberService;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.member.domain.exception.WrongPasswordException;
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

    public ResponseData<Token> login(LoginReq req){
        Member member = memberService.getByEmail(req.email());
        verifyPw(req.pw(),member.getPw());
        Token token = tokenIssuer.issueToken(req.email(), member.getRole());
        return ResponseData.ok("로그인 성공", token);
    }

    private void verifyPw(String pw, String encodePw){
        if (!encoder.matches(pw, encodePw)) throw new WrongPasswordException();
    }
}
