package com.project.dasomapi.member.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.member.usecase.MemberUseCase;
import com.project.dasomapi.member.usecase.req.ChangePwReq;
import com.project.dasomapi.member.usecase.req.JoinReq;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberUseCase memberUseCase;

    // 선생님, 학부모 회원가입 요청을 분리할까??
    @PostMapping("/join")
    public Response join(@RequestBody @Valid JoinReq req){
        return memberUseCase.join(req);
    }

    @PatchMapping("/change-pw")
    public Response changePw(
            @RequestBody ChangePwReq req
    ) {
        return memberUseCase.changePw(req);
    }

}
