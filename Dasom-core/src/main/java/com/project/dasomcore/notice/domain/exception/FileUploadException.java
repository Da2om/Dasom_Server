package com.project.dasomcore.notice.domain.exception;

import com.project.dasomcore.common.exception.CustomException;
import com.project.dasomcore.common.exception.GlobalExceptionCode;

public class FileUploadException extends CustomException {
    public FileUploadException() {
        super(GlobalExceptionCode.INTERNAL_SERVER);
    }
}
