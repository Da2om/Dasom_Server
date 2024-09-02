package com.project.dasomcore.schedule.repo.querydsl;

import com.project.dasomapi.schedule.request.ScheduleListReq;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.project.dasomcore.schedule.application.response.ScheduleRes;
import com.project.dasomcore.schedule.domain.entity.Schedule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomScheduleRepoImpl implements CustomScheduleRepo{

    private final JPAQueryFactory query;

    @Override
    public List<ScheduleRes> scheduleList(ScheduleListReq req) {
        return query.select(Projection.constructor(ScheduleRes.class,
                        schedule.startDt,
                schedule.endDt,
                schedule.content
                ))
                .from(schedule)
                .where(schedule.startDt.year().eq(Integer.parseInt(req.year()))
                        .and(schedule.startDt.month().eq(Integer.parseInt(req.month()))))
                .fetch();
    }
}
