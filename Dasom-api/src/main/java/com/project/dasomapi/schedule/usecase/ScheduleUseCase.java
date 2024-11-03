package com.project.dasomapi.schedule.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.schedule.usecase.req.RegisterScheduleReq;
import com.project.dasomapi.schedule.usecase.req.ScheduleListReq;
import com.project.dasomcore.schedule.application.response.ScheduleRes;
import com.project.dasomcore.schedule.application.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduleUseCase {

    private final ScheduleService scheduleService;

    public Response register(List<RegisterScheduleReq> requests) {
        for(RegisterScheduleReq req : requests) {
            scheduleService.save(req.toEntity());
        }
        return Response.created("일정 저장 성공");
    }

    public ResponseData<List<ScheduleRes>> scheduleList(ScheduleListReq req){
        List<ScheduleRes> res = scheduleService.scheduleList(req.year(),req.month());
        return ResponseData.ok("일정 리스트 조회 성공",res);
    }

}
