package com.project.dasomcore.schedule.application.response;

import java.time.LocalDate;

public record ScheduleRes(Long scheduleId,String activity,LocalDate startDt,LocalDate endDt) {
}
