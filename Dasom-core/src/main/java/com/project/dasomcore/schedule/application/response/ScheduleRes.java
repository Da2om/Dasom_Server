package com.project.dasomcore.schedule.application.response;

import java.time.LocalDate;

public record ScheduleRes(LocalDate startDt,LocalDate endDt,String content) {
}
