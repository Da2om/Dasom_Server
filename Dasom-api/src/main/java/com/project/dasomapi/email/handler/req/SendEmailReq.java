package com.project.dasomapi.email.handler.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SendEmailReq(@NotBlank(message = "이메일 입력은 필수입니다.")
                           @Email(message = "이메일 형식에 맞게 입력해 주세요.")
                           String email) {
}
