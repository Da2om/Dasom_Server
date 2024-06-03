package com.project.dasomcore.child.repo;

import com.project.dasomcore.child.application.MyChildInfoRes;
import com.project.dasomcore.member.domain.entity.Member;

import java.util.List;

public interface QuerydslChildRepository {
    List<MyChildInfoRes> findMyChildByMember(Member member);
}
