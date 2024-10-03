package com.project.dasomcore.schedule.repo;

import com.project.dasomcore.schedule.application.response.ScheduleRes;

import java.util.List;

public interface QuerydslScheduleRepository {
    List<ScheduleRes> scheduleList(String year,String month);
}
