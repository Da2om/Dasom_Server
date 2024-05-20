package com.project.dasomapi.child.handler;

import com.project.dasomapi.child.usecase.ChildUseCase;
import com.project.dasomapi.child.usecase.req.ChildRegisterReq;
import com.project.dasomapi.common.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/child")
public class ChildController {
    private final ChildUseCase childUseCase;

    @PostMapping
    public Response register(@RequestBody @Valid ChildRegisterReq req){
        return childUseCase.register(req);
    }
}
