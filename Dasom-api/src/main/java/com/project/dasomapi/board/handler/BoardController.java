package com.project.dasomapi.board.handler;

import com.project.dasomapi.board.usecase.BoardUseCase;
import com.project.dasomapi.board.usecase.req.BoardReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.inq.handler.req.SaveInqReq;
import com.project.dasomcore.board.application.res.BoardRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardUseCase useCase;

    @PostMapping("")
    @Operation(summary = "공지 저장", description = "공지 저장(teacher)")
    public Response register(
            @RequestBody BoardReq req
    ){
        return useCase.register(req);
    }

    @GetMapping("")
    @Operation(summary = "공지 리스트 조회", description = "공지 리스트 조회(teacher)")
    public ResponseData<List<BoardRes>> getBoards(
    ){
        return useCase.getBoards();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "공지 수정", description = "공지 수정(teacher)")
    public Response modify(
            @PathVariable("id") Long id,
            @RequestBody BoardReq req
    ){
        return useCase.modify(id,req);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "공지 삭제", description = "공지 삭제(teacher)")
    public Response remove(
            @PathVariable("id") Long id
    ){
        return useCase.remove(id);
    }

}
