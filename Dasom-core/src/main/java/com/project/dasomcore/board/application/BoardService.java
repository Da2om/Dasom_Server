package com.project.dasomcore.board.application;

import com.project.dasomcore.board.application.res.BoardRes;
import com.project.dasomcore.board.domain.entity.Board;
import com.project.dasomcore.board.domain.exception.BoardNotFoundException;
import com.project.dasomcore.board.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public List<BoardRes> getBoards() {
        return boardRepository.getBoards();
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    public Board getById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(BoardNotFoundException::new);
    }
}
