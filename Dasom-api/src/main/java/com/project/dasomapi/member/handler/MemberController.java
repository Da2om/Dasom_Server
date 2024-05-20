package com.project.dasomapi.member.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.member.usecase.MemberUseCase;
import com.project.dasomapi.member.usecase.req.JoinReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberUseCase memberUseCase;

    @PostMapping("/join")
    public Response join(JoinReq req){
        return memberUseCase.join(req);
    }
}
