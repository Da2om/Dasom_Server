package com.project.dasomapi.child.usecase;

import com.project.dasomapi.child.usecase.req.ChildRegisterReq;
import com.project.dasomapi.common.Response;
import com.project.dasomcore.child.application.ChildService;
import com.project.dasomcore.member.application.MemberSessionHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
}
