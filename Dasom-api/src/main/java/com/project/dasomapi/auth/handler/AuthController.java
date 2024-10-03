package com.project.dasomapi.auth.handler;

import com.project.dasomapi.auth.usecase.AuthUseCase;
import com.project.dasomapi.auth.usecase.req.LoginReq;
import com.project.dasomapi.auth.usecase.req.ReissueReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.auth.application.dto.Token;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "AUTH", description = "auth API")
@RequestMapping("/auth")
public class AuthController {
    private final AuthUseCase authUseCase;

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "username(아이디)&비번으로, 토큰을 반환 (unauthenticated)")
    public ResponseData<Token> login(@RequestBody @Valid LoginReq req){
        return authUseCase.login(req);
    }

    @PostMapping("/reissue")
    @Operation(summary = "토큰 재발급", description = "refreshToken으로 accessToken 재발급 (unauthenticated)")
    public Response reissue(@RequestBody @Valid ReissueReq req){
        return authUseCase.reissue(req);
    }
}
