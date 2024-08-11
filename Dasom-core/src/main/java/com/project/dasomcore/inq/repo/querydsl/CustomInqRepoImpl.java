package com.project.dasomcore.inq.repo.querydsl;

import com.project.dasomapi.common.request.PageRequest;
import com.project.dasomapi.inq.handler.req.InqInfoRes;
import com.project.dasomcore.inq.application.response.InqRes;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomInqRepoImpl implements CustomInqRepo {

    private final JPAQueryFactory query;

    @Override
    public List<InqRes> inqList(PageRequest req) {
        return query.select(Projection.constructor(InqRes.class,
                        inq.title
                ))
                .from(inq)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(inq.inqId.desc())
                .fetch();
    }

    @Override
    public InqInfoRes inqInfo(Long inqId) {
        return query.select(Projection.constructor(InqInfoRes.class,
                        inq.title,
                        inq.content,
                        member.name))
                .from(inq)
                .innerJoin(member).on(member.memberId.eq(inq.fkMemberId))
                .orderBy(inq.inqId.desc())
                .fetchOne();
    }
}
