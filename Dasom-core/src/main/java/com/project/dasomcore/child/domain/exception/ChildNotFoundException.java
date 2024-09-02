package com.project.dasomcore.child.domain.exception;

import com.project.dasomcore.common.exception.CustomException;
import com.project.dasomcore.member.domain.exception.MemberExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ChildNotFoundException extends CustomException {

    public ChildNotFoundException() {
        super(MemberExceptionCode.WRONG_PASSWORD);
    }

}