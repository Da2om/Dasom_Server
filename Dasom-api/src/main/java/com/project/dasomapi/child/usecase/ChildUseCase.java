package com.project.dasomapi.child.usecase;

import com.project.dasomapi.child.usecase.req.ChildModifyReq;
import com.project.dasomapi.child.usecase.req.ChildRegisterReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.child.application.ChildRes;
import com.project.dasomcore.child.application.ChildService;
import com.project.dasomcore.child.application.MyChildInfoRes;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomcore.member.application.MemberSessionHolder;
import com.project.dasomcore.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ChildUseCase {
    private final ChildService childService;
    private final MemberSessionHolder sessionHolder;

    public Response register(ChildRegisterReq req){
        childService.save(req.toEntity(sessionHolder.current()));
        return Response.created("아이 등록 성공");
    }

    public Response modify(ChildModifyReq req){
        Child child = childService.getById(req.id());
        child.modify(req.toEntity());
        childService.save(child);
        return Response.created("아이 수정 성공");
    }

    public ResponseData<List<MyChildInfoRes>> getMyChild(){
        Member member = sessionHolder.current();
        List<MyChildInfoRes> childList = childService.getMyChildList(member);
        return ResponseData.ok("내 아이 조회 성공", childList);
    }

    public ResponseData<List<ChildRes>> getChildList(PageRequest pageRequest){
        pageRequest.validate();
        List<ChildRes> res = childService.getChildResList(pageRequest.page(),pageRequest.size());
        return ResponseData.ok("아이 리스트 조회 성공", res);
    }
}
