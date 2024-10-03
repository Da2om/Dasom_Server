package com.project.dasomapi.email.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.email.handler.req.SendEmailReq;
import com.project.dasomapi.email.handler.req.VerifyEmailReq;
import com.project.dasomapi.email.usecase.EmailUseCase;
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
public class EmailController {

    private final EmailUseCase emailUseCase;

    @PostMapping("")
    public Response sendEmail(@RequestBody @Valid SendEmailReq req){
        return emailUseCase.sendEmail(req);
    }

    @GetMapping("/verify")
    public Response verifyEmail(
            @ModelAttribute VerifyEmailReq req
    ) {
        return emailUseCase.verifyEmail(req);
    }

}
