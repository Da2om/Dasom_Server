package com.project.dasomcore.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends CustomException {

    public InternalServerException() {
        super(GlobalExceptionCode.INTERNAL_SERVER);
    }
}
