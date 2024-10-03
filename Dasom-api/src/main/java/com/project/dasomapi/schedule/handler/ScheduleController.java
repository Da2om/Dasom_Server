package com.project.dasomapi.schedule.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.schedule.request.SaveScheduleRequest;
import com.project.dasomapi.schedule.request.ScheduleListReq;
import com.project.dasomapi.schedule.usecase.ScheduleUseCase;
import com.project.dasomcore.schedule.application.response.ScheduleRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
@Tag(name = "일정", description = "일정 API")
public class ScheduleController {

    private final ScheduleUseCase useCase;

    /**
     * 일정 작성
     * */
    @PostMapping
    @Operation(summary = "일정 작성", description = "일정 저장(teacher)")
    public Response saveSchedule(
            @RequestBody SaveScheduleRequest req
    ){
        return useCase.saveSchedule(req);
    }

    /**
     * 일정 리스트
     * */
    @GetMapping("/list")
    @Transactional(readOnly = true)
    @Operation(summary = "일정 리스트", description = "일정 리스트 조회(authorized)")
    public ResponseData<List<ScheduleRes>> scheduleList(
            @ModelAttribute ScheduleListReq req
    ){
        return useCase.scheduleList(req);
    }

}
