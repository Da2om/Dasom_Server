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
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/child")
public class ChildController {
    private final ChildUseCase childUseCase;

    @PostMapping("/image")
    public ResponseData<UploadChildImageRes> uploadChildImage(@RequestBody UploadChildImageReq req) {
        return childUseCase.uploadImage(req);
    }

    @PostMapping
    public Response register(@RequestBody @Valid ChildRegisterReq req){
        return childUseCase.register(req);
    }

    @PatchMapping
    public Response modify(@RequestBody @Valid ChildModifyReq req){
        return childUseCase.modify(req);
    }

    @GetMapping("/my")
    public ResponseData<List<MyChildInfoRes>> getMyChild(){
        return childUseCase.getMyChild();
    }

    @GetMapping
    public ResponseData<List<ChildRes>> getList(
            @ModelAttribute PageRequest pageRequest
    ){
        return childUseCase.getChildList(pageRequest);
    }

    @GetMapping("/class-list")
    public ResponseData<List<ChildRes>> getListByClass(
            @ModelAttribute PageRequest pageRequest,
            @RequestParam MemberClass cls){
        return childUseCase.getListByClass(pageRequest,cls);
    }

    @GetMapping("/search")
    public ResponseData<List<ChildRes>> searchChild(
            @ModelAttribute PageRequest pageRequest,
            @RequestParam String name){
        return childUseCase.searchChild(pageRequest,name);
    }

}
