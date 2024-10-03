package com.project.dasomcore.mail.domain.exception;

import com.project.dasomcore.common.exception.CustomException;

public class EmailAlreadyExistsException extends CustomException {

    public EmailAlreadyExistsException() {
        super(MailExceptionCode.EMAIL_EXISTS);
    }

}