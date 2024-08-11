package com.project.dasomapi.schedule.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.schedule.request.SaveScheduleRequest;
import com.project.dasomapi.schedule.request.ScheduleListReq;
import com.project.dasomcore.schedule.application.response.ScheduleRes;
import com.project.dasomcore.schedule.application.service.ScheduleRegisterService;
import com.project.dasomcore.schedule.application.service.ScheduleSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduleUseCase {

    private final ScheduleRegisterService scheduleRegisterService;
    private final ScheduleSearchService scheduleSearchService;

    public Response saveSchedule(SaveScheduleRequest req) {
        scheduleRegisterService.saveSchedule(req.toEntity());
        return Response.created("일정 저장 성공");
    }

    public ResponseData<List<ScheduleRes>> scheduleList(ScheduleListReq req){
        return ResponseData.ok("일정 리스트 조회 성공",scheduleSearchService.scheduleList(req));
    }

}
