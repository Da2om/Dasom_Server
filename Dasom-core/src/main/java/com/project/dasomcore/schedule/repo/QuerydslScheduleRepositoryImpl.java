package com.project.dasomcore.schedule.repo;

import com.project.dasomcore.schedule.application.response.ScheduleRes;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.dasomcore.schedule.domain.entity.QSchedule.schedule;

@Repository
@RequiredArgsConstructor
public class QuerydslScheduleRepositoryImpl implements QuerydslScheduleRepository {

    private final JPAQueryFactory query;

    @Override
    public List<ScheduleRes> scheduleList(String year,String month) {
        return query.select(Projections.constructor(ScheduleRes.class,
                        schedule.scheduleId,
                        schedule.startDt,
                        schedule.endDt,
                        schedule.activity
                ))
                .from(schedule)
                .where(schedule.startDt.year().eq(Integer.parseInt(year))
                        .and(schedule.startDt.month().eq(Integer.parseInt(month))))
                .fetch();
    }
}
