package com.project.dasomcore.board.repo;

import com.project.dasomcore.board.application.res.BoardRes;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.dasomcore.board.domain.entity.QBoard.board;

@Repository
@RequiredArgsConstructor
public class QuerydslBoardRepositoryImpl implements QuerydslBoardRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardRes> getBoards() {
        return queryFactory
                .select(Projections.constructor(BoardRes.class,
                        board.id,
                        board.title,
                        board.content,
                        board.writtenDt
                ))
                .from(board)
                .fetch();
    }
}
