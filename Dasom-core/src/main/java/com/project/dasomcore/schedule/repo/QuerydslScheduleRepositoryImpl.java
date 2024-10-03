package com.project.dasomcore.schedule.repo;

import com.project.dasomcore.schedule.application.response.ScheduleRes;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuerydslScheduleRepositoryImpl implements QuerydslScheduleRepository {

    private final JPAQueryFactory query;

    @Override
    public List<ScheduleRes> scheduleList(String year,String month) {
//        return query.select(Projection.constructor(ScheduleRes.class,
//                        schedule.startDt,
//                schedule.endDt,
//                schedule.content
//                ))
//                .from(schedule)
//                .where(schedule.startDt.year().eq(Integer.parseInt(req.year()))
//                        .and(schedule.startDt.month().eq(Integer.parseInt(req.month()))))
//                .fetch();
        return null;
    }
}
