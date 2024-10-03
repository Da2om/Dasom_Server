package com.project.dasomapi.email.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.email.handler.req.SendEmailReq;
import com.project.dasomapi.email.handler.req.VerifyEmailReq;
import com.project.dasomapi.email.usecase.EmailUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@Tag(name = "이메일", description = "이메일 API")
public class EmailController {

    private final EmailUseCase emailUseCase;

    @PostMapping("")
    @Operation(summary = "이메일 인증번호 요청", description = "이메일 인증번호를 전송 (unauthorized)")
    public Response sendEmail(@RequestBody @Valid SendEmailReq req){
        return emailUseCase.sendEmail(req);
    }

    @GetMapping("/verify")
    @Operation(summary = "이메일 인증", description = "인증번호를 통해 이메일 인증처리 (unauthorized)")
    public Response verifyEmail(
            @ModelAttribute VerifyEmailReq req
    ) {
        return emailUseCase.verifyEmail(req);
    }

}
