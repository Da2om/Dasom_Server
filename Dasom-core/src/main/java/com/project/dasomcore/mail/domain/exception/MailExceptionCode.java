package com.project.dasomcore.mail.domain.exception;

import com.project.dasomcore.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum MailExceptionCode implements ExceptionCode {

    EMAIL_EXISTS(HttpStatus.BAD_REQUEST, "이미 등록된 이메일"),
    EMAIL_SEND_FAILED(HttpStatus.INTERNAL_SERVER_ERROR,"이메일 전송 실패"),
    EMAIL_NOTFOUND(HttpStatus.NOT_FOUND,"이메일을 찾을 수 없음"),
    INVALID_CODE(HttpStatus.BAD_REQUEST,"잘못된 인증코드");

    private final HttpStatus status;
    private final String message;

    @Override
    public HttpStatus getHttpStatus() {
        return this.status;
    }

    @Override
    public String getExceptionName() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

