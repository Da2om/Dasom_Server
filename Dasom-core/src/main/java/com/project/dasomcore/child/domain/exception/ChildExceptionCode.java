package com.project.dasomcore.child.domain.exception;

import com.project.dasomcore.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ChildExceptionCode implements ExceptionCode {

    CHILD_NOTFOUND(HttpStatus.NOT_FOUND, "아이를 찾을 수 없음"),;

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

