package com.project.dasomapi.child.handler;

import com.project.dasomapi.child.usecase.ChildUseCase;
import com.project.dasomapi.child.usecase.req.ChildModifyReq;
import com.project.dasomapi.child.usecase.req.ChildRegisterReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.child.application.ChildRes;
import com.project.dasomcore.child.application.MyChildInfoRes;
import com.project.dasomapi.common.dto.PageRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/child")
public class ChildController {
    private final ChildUseCase childUseCase;

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
    public ResponseData<List<ChildRes>> getList(PageRequest pageRequest){
        return childUseCase.getChildList(pageRequest);
    }
}
