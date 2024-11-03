package com.project.dasomcore.board.application.res;

import java.time.LocalDateTime;

public record BoardRes(
        Long boardId,
        String title,
        String content,
        LocalDateTime writtenDt
) {
}
