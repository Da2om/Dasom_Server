package com.project.dasomcore.schedule.repo.querydsl;

import com.project.dasomapi.schedule.request.ScheduleListReq;
import com.project.dasomcore.schedule.application.response.ScheduleRes;

import java.util.List;

public interface CustomScheduleRepo {
    List<ScheduleRes> scheduleList(ScheduleListReq req);
}
