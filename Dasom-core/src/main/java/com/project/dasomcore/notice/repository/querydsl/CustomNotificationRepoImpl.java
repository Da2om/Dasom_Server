package com.project.dasomcore.notice.repository.querydsl;

import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.notice.application.response.NoticeRes;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<NoticeRes> noticeList() {
        return query.select(Projection.constructor(NoticeRes.class,
                notice.noticeId,
                notice.title,
                notice.content))
                .from(notice)
                .fetch();
    }


}
