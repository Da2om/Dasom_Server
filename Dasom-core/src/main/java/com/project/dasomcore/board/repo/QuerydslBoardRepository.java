package com.project.dasomcore.board.repo;

import com.project.dasomcore.board.application.res.BoardRes;

import java.util.List;

public interface QuerydslBoardRepository {
    List<BoardRes> getBoards();
}
