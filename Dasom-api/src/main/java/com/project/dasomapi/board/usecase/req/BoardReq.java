package com.project.dasomapi.board.usecase.req;

import com.project.dasomcore.board.domain.entity.Board;

import java.time.LocalDateTime;

public record BoardReq(
        String title,
        String content
) {
    public Board toEntity() {
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .writtenDt(LocalDateTime.now()).build();
    }
}
