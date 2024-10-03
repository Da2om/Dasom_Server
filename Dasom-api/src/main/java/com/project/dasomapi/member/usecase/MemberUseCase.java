package com.project.dasomapi.member.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.member.usecase.req.ChangePwReq;
import com.project.dasomapi.member.usecase.req.JoinReq;
import com.project.dasomcore.auth.application.PasswordEncoder;
import com.project.dasomcore.member.application.MemberService;
import com.project.dasomcore.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberUseCase {
    private final MemberService memberService;
    private final PasswordEncoder encoder;

    public Response join(JoinReq req){
        Member member = req.toEntity(encoder.encode(req.pw()));
        memberService.save(member);
        return Response.created("회원가입 성공");
    }

    public Response changePw(ChangePwReq req) {
        Member member = memberService.getByUsername(req.username());
        member.updatePassword(encoder.encode(req.password()));
        return Response.ok("비밀번호 변경 성공");
    }
}
