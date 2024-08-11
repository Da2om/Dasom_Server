package com.project.dasomapi.schedule.request;

import com.project.dasomcore.schedule.domain.entity.Schedule;

import java.time.LocalDate;

public record SaveScheduleRequest(LocalDate startDt,LocalDate endDt, String content) {
    public Schedule toEntity(){
        return Schedule.builder()
                .content(this.content)
                .startDt(this.startDt)
                .endDt(this.endDt).build();
    }
}
