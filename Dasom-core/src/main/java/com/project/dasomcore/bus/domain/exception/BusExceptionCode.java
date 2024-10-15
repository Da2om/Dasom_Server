package com.project.dasomcore.bus.domain.exception;

import com.project.dasomcore.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum BusExceptionCode implements ExceptionCode {

    BUS_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 버스신청");

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

