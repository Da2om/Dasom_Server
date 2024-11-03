package com.project.dasomcore.board.domain.exception;

import com.project.dasomcore.common.exception.CustomException;

public class BoardNotFoundException extends CustomException {
    public BoardNotFoundException() {
        super(BoardExceptionCode.BOARD_NOT_FOUND);
    }
}