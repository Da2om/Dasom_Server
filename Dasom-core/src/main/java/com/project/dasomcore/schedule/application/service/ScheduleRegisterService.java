package com.project.dasomcore.schedule.application.service;

import com.project.dasomcore.schedule.repo.ScheduleRepository;
import com.project.dasomcore.schedule.domain.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleRegisterService {

    private final ScheduleRepository scheduleRepository;

    public void saveSchedule(Schedule schedule){
        scheduleRepository.save(schedule);
    }
}
