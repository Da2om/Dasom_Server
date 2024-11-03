package com.project.dasomcore.member.domain.exception;

import com.project.dasomcore.common.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DuplicatedMemberException extends CustomException {

    public DuplicatedMemberException() {
        super(MemberExceptionCode.MEMBER_DUPLICATION);
    }

}