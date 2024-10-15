package com.project.dasomcore.board.repo;

import com.project.dasomcore.board.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long>,QuerydslBoardRepository {
}
