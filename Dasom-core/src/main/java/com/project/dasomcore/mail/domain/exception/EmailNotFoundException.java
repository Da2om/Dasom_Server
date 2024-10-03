package com.project.dasomcore.mail.domain.exception;

import com.project.dasomcore.common.exception.CustomException;

public class EmailNotFoundException extends CustomException {

    public EmailNotFoundException() {
        super(MailExceptionCode.EMAIL_NOTFOUND);
    }

}