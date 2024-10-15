package com.project.dasomapi.bus.handler;

import com.project.dasomapi.bus.usecase.BusUseCase;
import com.project.dasomapi.bus.usecase.req.ModifyBusReq;
import com.project.dasomapi.bus.usecase.req.RegisterBusReq;
import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomcore.bus.application.res.BusRes;
import com.project.dasomcore.bus.application.res.MyBusRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {

    private final BusUseCase busUseCase;

    @PostMapping("")
    @Operation(summary = "버스 신청", description = "버스 탑승 신청 (parent)")
    public Response register(
            @RequestBody RegisterBusReq req
    ){
        return busUseCase.register(req);
    }

    @GetMapping("/my")
    @Operation(summary = "내 버스 요청", description = "내 버스 탑승 신청 리스트 (parent)")
    public ResponseData<List<MyBusRes>> getMyBus(){
        return busUseCase.getMyBus();
    }

    @GetMapping("")
    @Operation(summary = "버스 신청명단 조회", description = "버스 신청명단 조회 가능 (teacher)")
    public ResponseData<List<BusRes>> getBusList(){
        return busUseCase.getBusList();
    }

    @GetMapping("/modified")
    @Operation(summary = "버스 수정명단 조회", description = "버스 수정명단 조회 가능 (teacher)")
    public ResponseData<List<BusRes>> getModifiedBusList(){
        return busUseCase.getModifiedBusList();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "버스 신청 수정", description = "버스 탑승 신청 수정(parent)")
    public Response modify(
            @PathVariable("id") Long id,
            @RequestBody ModifyBusReq req
    ){
        return busUseCase.modify(id,req);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "버스 신청 삭제", description = "버스 탑승 신청 삭제(parent)")
    public Response remove(
            @PathVariable("id") Long id
    ){
        return busUseCase.remove(id);
    }

}
