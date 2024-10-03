package com.project.dasomcore.mail.domain.exception;

import com.project.dasomcore.common.exception.CustomException;

public class SendEmailException extends CustomException {

    public SendEmailException() {
        super(MailExceptionCode.EMAIL_SEND_FAILED);
    }

}