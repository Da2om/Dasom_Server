package com.project.dasomapi.schedule.usecase.req;

import com.project.dasomcore.schedule.domain.entity.Schedule;

import java.time.LocalDate;

public record RegisterScheduleReq(LocalDate startDt,LocalDate endDt, String activity) {
    public Schedule toEntity(){
        return Schedule.builder()
                .activity(this.activity)
                .startDt(this.startDt)
                .endDt(this.endDt).build();
    }
}
