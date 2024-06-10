package com.project.dasomcore.member.domain.exception;

import com.project.dasomcore.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum MemberExceptionCode implements ExceptionCode {

    WRONG_PASSWORD(HttpStatus.UNAUTHORIZED, "잘못된 비밀번호"),
    DEACTIVATE_MEMBER(HttpStatus.FORBIDDEN, "비활성화된 멤버"),
    MEMBER_DUPLICATION(HttpStatus.CONFLICT, "이미 존재하는 멤버"),;

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
