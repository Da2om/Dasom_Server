package com.project.dasomcore.inq.repo;

import com.project.dasomcore.inq.application.response.InqInfoRes;
import com.project.dasomcore.inq.application.response.InqRes;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuerydslInqRepositoryImpl implements QuerydslInqRepository {

    private final JPAQueryFactory query;

    @Override
    public List<InqRes> inqList(int page,int size) {
//        return query.select(Projections.constructor(InqRes.class,
//                        inq.title
//                ))
//                .from(inq)
//                .offset((request.getPage() - 1) * request.getSize())
//                .limit(request.getSize())
//                .orderBy(inq.inqId.desc())
//                .fetch();
        return List.of();
    }

    @Override
    public InqInfoRes inqInfo(Long inqId) {
//        return query.select(Projection.constructor(InqInfoRes.class,
//                        inq.title,
//                        inq.content,
//                        member.name))
//                .from(inq)
//                .innerJoin(member).on(member.memberId.eq(inq.fkMemberId))
//                .orderBy(inq.inqId.desc())
//                .fetchOne();
        return null;
    }
}
