package com.project.dasomapi.board.usecase;

import com.project.dasomapi.board.usecase.req.BoardReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.board.application.BoardService;
import com.project.dasomcore.board.application.res.BoardRes;
import com.project.dasomcore.board.domain.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardUseCase {

    private final BoardService boardService;

    public Response register(BoardReq req) {
        boardService.save(req.toEntity());
        return Response.created("공지 저장 성공");
    }

    public ResponseData<List<BoardRes>> getBoards() {
        List<BoardRes> res = boardService.getBoards();
        return ResponseData.ok("공지 리스트 조회 성공",res);
    }

    public Response modify(Long boardId, BoardReq req) {
        Board board = boardService.getById(boardId);
        board.update(req.title(),req.content());
        return Response.ok("공지 수정 성공");
    }

    public Response remove(Long id) {
        boardService.deleteById(id);
        return Response.ok("공지 삭제 성공");
    }
}
