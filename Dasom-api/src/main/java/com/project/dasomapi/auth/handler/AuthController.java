package com.project.dasomapi.auth.handler;

import com.project.dasomapi.auth.usecase.AuthUseCase;
import com.project.dasomapi.auth.usecase.req.LoginReq;
import com.project.dasomapi.common.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthUseCase authUseCase;

    @PostMapping("/login")
    public Response login(LoginReq req){
        return authUseCase.login(req);
    }
}
