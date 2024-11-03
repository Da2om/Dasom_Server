package com.project.dasomcore.bus.repo;

import com.project.dasomcore.bus.application.res.BusRes;
import com.project.dasomcore.bus.application.res.MyBusRes;
import com.project.dasomcore.member.domain.entity.Member;

import java.util.List;

public interface QuerydslBusRepository {
    List<MyBusRes> getMyBus(Member member);

    List<BusRes> getBusList();

    List<BusRes> getModifiedBusList();
}
