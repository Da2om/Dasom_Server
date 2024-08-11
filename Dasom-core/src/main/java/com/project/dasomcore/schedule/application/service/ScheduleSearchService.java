package com.project.dasomcore.schedule.application.service;

import com.project.dasomapi.schedule.request.ScheduleListReq;
import com.project.dasomcore.schedule.repo.ScheduleRepository;
import com.project.dasomcore.schedule.application.response.ScheduleRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleSearchService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleRes> scheduleList(ScheduleListReq req){
        return scheduleRepository.scheduleList(req);
    }
}
