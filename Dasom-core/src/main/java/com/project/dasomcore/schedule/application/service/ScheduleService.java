package com.project.dasomcore.schedule.application.service;

import com.project.dasomcore.schedule.domain.entity.Schedule;
import com.project.dasomcore.schedule.repo.ScheduleRepository;
import com.project.dasomcore.schedule.application.response.ScheduleRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleRes> scheduleList(String year,String month){
        return scheduleRepository.scheduleList(year,month);
    }

    public void save(Schedule schedule){
        scheduleRepository.save(schedule);
    }
}
