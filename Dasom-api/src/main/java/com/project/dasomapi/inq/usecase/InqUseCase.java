package com.project.dasomapi.inq.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.inq.handler.req.SaveInqReq;
import com.project.dasomcore.inq.application.service.InqService;
import com.project.dasomcore.member.application.MemberSessionHolder;
import com.project.dasomcore.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InqUseCase {

    private final InqService inqService;
    private final MemberSessionHolder memberSessionHolder;

    public Response saveInq(SaveInqReq req){
        Member member = memberSessionHolder.current();
        inqService.saveInq(req.toEntity(member));
        return Response.created("문의 저장 성공");
    }

//    public ResponseData<List<InqRes>> inqList(PageRequest req){
////        return ResponseData.ok("문의 리스트 조회 성공",inqSearchService.inqList(req.page(),req.size()));
//        return null;
//    }
//
//    public ResponseData<InqInfoRes> inqInfo(Long inqId) {
//        return ResponseData.ok("알림장 조회 성공", inqSearchService.inqInfo(inqId));
//    }

}
