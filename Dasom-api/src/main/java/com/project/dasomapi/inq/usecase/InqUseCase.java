package com.project.dasomapi.inq.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomcore.inq.application.response.InqInfoRes;
import com.project.dasomapi.inq.handler.req.SaveInqReq;
import com.project.dasomcore.inq.application.response.InqRes;
import com.project.dasomcore.inq.application.service.InqRegisterService;
import com.project.dasomcore.inq.application.service.InqSearchService;
import com.project.dasomcore.member.application.MemberSessionHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InqUseCase {

    private final InqRegisterService inqRegisterService;
    private final InqSearchService inqSearchService;
    private final MemberSessionHolder memberSessionHolder;

    public Response saveInq(SaveInqReq req){
        inqRegisterService.saveInq(req.toEntity(memberSessionHolder.current().getEmail()));
        return Response.created("문의 저장 성공");
    }

    public ResponseData<List<InqRes>> inqList(PageRequest req){
//        return ResponseData.ok("문의 리스트 조회 성공",inqSearchService.inqList(req.page(),req.size()));
        return null;
    }

    public ResponseData<InqInfoRes> inqInfo(Long inqId) {
        return ResponseData.ok("알림장 조회 성공", inqSearchService.inqInfo(inqId));
    }

}
