package com.project.dasomcore.member.application;

import com.project.dasomcore.mail.domain.exception.EmailAlreadyExistsException;
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

    public void checkEmailExists(String email) {
        if(memberRepository.existsById(email))
            throw new EmailAlreadyExistsException();
    }

    public Member getByUsername(String username){
        return memberRepository.findByUsername(username);
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }
}
