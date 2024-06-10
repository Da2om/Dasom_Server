package com.project.dasomcore.auth.domain.exception;

import com.project.dasomcore.common.exception.CustomException;
import com.project.dasomcore.common.exception.GlobalExceptionCode;

public class ReissueTokenException extends CustomException {

    public ReissueTokenException() {
        super(GlobalExceptionCode.TOKEN_EXPIRED);
    }

}