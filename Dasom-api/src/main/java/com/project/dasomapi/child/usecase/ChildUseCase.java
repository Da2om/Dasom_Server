package com.project.dasomapi.child.usecase;

import com.project.dasomapi.child.usecase.req.ChildModifyReq;
import com.project.dasomapi.child.usecase.req.ChildRegisterReq;
import com.project.dasomapi.child.usecase.req.UploadChildImageReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.child.application.response.ChildRes;
import com.project.dasomcore.child.application.ChildService;
import com.project.dasomcore.child.application.response.MyChildInfoRes;
import com.project.dasomcore.child.application.response.UploadChildImageRes;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomcore.member.application.MemberSessionHolder;
import com.project.dasomcore.member.domain.consts.MemberClass;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.notice.application.service.AwsS3Service;
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
    private final AwsS3Service awsS3Service;

    public ResponseData<UploadChildImageRes> uploadImage(UploadChildImageReq req) {
        String url = awsS3Service.upload(req.file(),"child_image");
        UploadChildImageRes res = UploadChildImageRes.of(url);
        return ResponseData.created("아이 사진 업로드 성공",res);
    }

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
        return ResponseData.ok("원아 전체리스트 조회 성공", res);
    }

    public ResponseData<List<ChildRes>> getListByClass(PageRequest pageRequest, MemberClass cls) {
        pageRequest.validate();
        List<ChildRes> res = childService.getChildResListByClass(pageRequest.page(),pageRequest.size(),cls);
        return ResponseData.ok("반에 따른 원아 리스트 조회 성공",res);
    }

    public ResponseData<List<ChildRes>> searchChild(PageRequest pageRequest,String name) {
        pageRequest.validate();
        List<ChildRes> res = childService.getChildResListByName(pageRequest.page(),pageRequest.size(),name);
        return ResponseData.ok("이름으로 원아 조회 성공",res);
    }
}
