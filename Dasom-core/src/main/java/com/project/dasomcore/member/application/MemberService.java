package com.project.dasomcore.member.application;

import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.member.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getByEmail(String email){
        return memberRepository.findByEmail(email);
    }
}
