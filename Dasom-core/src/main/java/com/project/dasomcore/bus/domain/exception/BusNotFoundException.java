package com.project.dasomcore.bus.domain.exception;

import com.project.dasomcore.common.exception.CustomException;
import com.project.dasomcore.common.exception.GlobalExceptionCode;

public class BusNotFoundException extends CustomException {
    public BusNotFoundException() {
        super(BusExceptionCode.BUS_NOT_FOUND);
    }
}