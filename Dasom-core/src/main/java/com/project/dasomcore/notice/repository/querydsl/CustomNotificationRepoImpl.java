package com.project.dasomcore.notice.repository.querydsl;

import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.NoticeRes;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import com.project.dasomapi.common.request.PageRequest;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.dasomcore.notice.domain.entity.QNotice.notice;
import static com.project.dasomcore.member.domain.entity.QMember.member;

@Repository
@RequiredArgsConstructor
public class CustomNotificationRepoImpl implements CustomNotificationRepo {

    private final JPAQueryFactory query;


    @Override
    public NoticeInfoRes noticeInfo(Long noticeId) {
        return query.select(Projection.constructor(NoticeInfoRes.class,
                notice.title,
                notice.writtenDt,
                notice.content,
                        member.name
                ))
                .from(notice)
                .innerJoin(member).on(member.userId.eq(noticeId))
                .fetchOne();
    }

    @Override
    public List<NoticeRes> noticeList(PageRequest request) {
        return query.select(Projection.constructor(NoticeRes.class,
                notice.noticeId,
                notice.title,
                notice.content))
                .from(notice)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(notice.idx.desc())
                .fetch();
    }


}
