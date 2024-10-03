package com.project.dasomapi.child.handler;

import com.project.dasomapi.child.usecase.ChildUseCase;
import com.project.dasomapi.child.usecase.req.ChildModifyReq;
import com.project.dasomapi.child.usecase.req.ChildRegisterReq;
import com.project.dasomapi.child.usecase.req.UploadChildImageReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.child.application.response.ChildRes;
import com.project.dasomcore.child.application.response.MyChildInfoRes;
import com.project.dasomapi.common.dto.PageRequest;
import com.project.dasomcore.child.application.response.UploadChildImageRes;
import com.project.dasomcore.member.domain.consts.MemberClass;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/child")
@Tag(name = "원아", description = "원아 API")
public class ChildController {
    private final ChildUseCase childUseCase;

    @PostMapping("/image")
    @Operation(summary = "이미지 저장", description = "이미지 저장 요청 (parent)")
    public ResponseData<UploadChildImageRes> uploadChildImage(@RequestBody UploadChildImageReq req) {
        return childUseCase.uploadImage(req);
    }

    @PostMapping
    @Operation(summary = "원아 저장", description = "원아 정보 저장 요청 (parent)")
    public Response register(@RequestBody @Valid ChildRegisterReq req){
        return childUseCase.register(req);
    }

    @PatchMapping
    @Operation(summary = "원아 정보 수정", description = "원아 정보 수정 요청 (parent)")
    public Response modify(@RequestBody @Valid ChildModifyReq req){
        return childUseCase.modify(req);
    }

    @GetMapping("/my")
    @Operation(summary = "내 원아 조회", description = "내 원아리스트 조회 (parent)")
    public ResponseData<List<MyChildInfoRes>> getMyChild(){
        return childUseCase.getMyChild();
    }

    @GetMapping
    @Operation(summary = "전체 원아 조회", description = "전체 원아리스트 조회 (teacher)")
    public ResponseData<List<ChildRes>> getList(
            @ModelAttribute PageRequest pageRequest
    ){
        return childUseCase.getChildList(pageRequest);
    }

    @GetMapping("/class-list")
    @Operation(summary = "반 원아 조회", description = "반 기준으로 원아리스트 조회 (teacher)")
    public ResponseData<List<ChildRes>> getListByClass(
            @ModelAttribute PageRequest pageRequest,
            @RequestParam MemberClass cls){
        return childUseCase.getListByClass(pageRequest,cls);
    }

    @GetMapping("/search")
    @Operation(summary = "원아 이름 조회", description = "원아 이름으로 조회 (teacher)")
    public ResponseData<List<ChildRes>> searchChild(
            @ModelAttribute PageRequest pageRequest,
            @RequestParam String name){
        return childUseCase.searchChild(pageRequest,name);
    }

}
