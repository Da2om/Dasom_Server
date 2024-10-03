package com.project.dasomcore.child.repo;

import com.project.dasomcore.child.application.response.ChildRes;
import com.project.dasomcore.child.application.response.MyChildInfoRes;
import com.project.dasomcore.member.domain.consts.MemberClass;
import com.project.dasomcore.member.domain.entity.Member;

import java.util.List;

public interface QuerydslChildRepository {
    List<MyChildInfoRes> findMyChildByMember(Member member);
    List<ChildRes> findList(Long page, Long size);
    List<ChildRes> findListByAssignedClass(Long page, Long size, MemberClass cls);
    List<ChildRes> getChildResListByName(Long page, Long size,String name);
}
