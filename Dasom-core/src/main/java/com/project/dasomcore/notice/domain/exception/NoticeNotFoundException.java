package com.project.dasomcore.notice.domain.exception;

import com.project.dasomcore.common.exception.CustomException;
import com.project.dasomcore.common.exception.GlobalExceptionCode;

public class NoticeNotFoundException extends CustomException {
    public NoticeNotFoundException() {
        super(GlobalExceptionCode.RESOURCE_NOT_FOUND);
    }
}
