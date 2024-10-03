package com.project.dasomcore.child.application;

import com.project.dasomcore.child.application.response.ChildRes;
import com.project.dasomcore.child.application.response.MyChildInfoRes;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.child.domain.exception.ChildNotFoundException;
import com.project.dasomcore.child.repo.ChildRepository;
import com.project.dasomcore.member.domain.consts.MemberClass;
import com.project.dasomcore.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ChildService {
    private final ChildRepository childRepository;

    public void save(Child child){
        childRepository.save(child);
    }

    public Child getById(Long id){
        return childRepository.findById(id).orElseThrow(ChildNotFoundException::new);
    }

    public List<MyChildInfoRes> getMyChildList(Member member){
        return childRepository.findMyChildByMember(member);
    }

    public List<ChildRes> getChildResList(Long page, Long size){
        return childRepository.findList(page,size);
    }

    public List<ChildRes> getChildResListByClass(Long page, Long size, MemberClass cls) {
        return childRepository.findListByAssignedClass(page,size,cls);
    }

    public List<ChildRes> getChildResListByName(Long page, Long size,String name) {
        return childRepository.getChildResListByName(page,size,name);
    }
}
