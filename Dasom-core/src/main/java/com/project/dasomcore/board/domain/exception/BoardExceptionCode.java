package com.project.dasomcore.board.domain.exception;

import com.project.dasomcore.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum BoardExceptionCode implements ExceptionCode {

    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 공지");

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

