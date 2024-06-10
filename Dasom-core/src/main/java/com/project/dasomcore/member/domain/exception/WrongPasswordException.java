package com.project.dasomcore.member.domain.exception;

import com.project.dasomcore.common.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class WrongPasswordException extends CustomException {

    public WrongPasswordException() {
        super(MemberExceptionCode.WRONG_PASSWORD);
    }

}