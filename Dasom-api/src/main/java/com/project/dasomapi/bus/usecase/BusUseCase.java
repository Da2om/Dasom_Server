package com.project.dasomapi.bus.usecase;

import com.project.dasomapi.bus.usecase.req.ModifyBusReq;
import com.project.dasomapi.bus.usecase.req.RegisterBusReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.bus.application.BusService;
import com.project.dasomcore.bus.application.res.BusRes;
import com.project.dasomcore.bus.application.res.MyBusRes;
import com.project.dasomcore.bus.domain.entity.Bus;
import com.project.dasomcore.child.application.ChildService;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.application.MemberSessionHolder;
import com.project.dasomcore.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BusUseCase {

    private final BusService busService;
    private final MemberSessionHolder memberSessionHolder;
    private final ChildService childService;

    public Response register(RegisterBusReq req) {
        Member member = memberSessionHolder.current();
        Child child = childService.getById(req.busId());
        busService.save(req.toEntity(member,child));
        return Response.created("버스 신청 성공");
    }

    public ResponseData<List<MyBusRes>> getMyBus() {
        Member member = memberSessionHolder.current();
        List<MyBusRes> res = busService.getMyBus(member);
        return ResponseData.ok("내 탑승신청 조회 성공",res);
    }

    public ResponseData<List<BusRes>> getBusList() {
        List<BusRes> res = busService.getBusList();
        return ResponseData.ok("버스 신청명단 조회 성공",res);
    }

    public ResponseData<List<BusRes>> getModifiedBusList() {
        List<BusRes> res = busService.getModifiedBusList();
        return ResponseData.ok("버스 수정명단 조회 성공",res);
    }

    public Response modify(Long id, ModifyBusReq req) {
        Bus bus = busService.getById(id);
        bus.update(req.boardTime(),req.isBoard());
        return Response.ok("탑승 신청 수정 성공");
    }

    public Response remove(Long id) {
        busService.deleteById(id);
        return Response.ok("탑승 신청 삭제 성공");
    }
}
