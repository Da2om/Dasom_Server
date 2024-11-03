package com.project.dasomapi.bus.usecase.req;

import com.project.dasomcore.bus.domain.entity.Bus;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.domain.entity.Member;

import java.time.LocalDateTime;

public record RegisterBusReq(
        Long busId,
        Long childId,
        LocalDateTime boardTime,
        boolean isBoard
) {
    public Bus toEntity(Member member, Child child) {
        return Bus.builder()
                .busId(this.busId)
                .boardTime(this.boardTime)
                .isBoard(this.isBoard)
                .member(member)
                .child(child).build();
    }
}
