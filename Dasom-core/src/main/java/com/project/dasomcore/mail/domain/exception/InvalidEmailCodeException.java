package com.project.dasomcore.mail.domain.exception;

import com.project.dasomcore.common.exception.CustomException;

public class InvalidEmailCodeException extends CustomException {

    public InvalidEmailCodeException() {
        super(MailExceptionCode.INVALID_CODE);
    }

}