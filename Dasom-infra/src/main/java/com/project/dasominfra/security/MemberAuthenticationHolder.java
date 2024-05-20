package com.project.dasominfra.security;

import com.project.dasomcore.member.application.MemberSessionHolder;
import com.project.dasomcore.member.domain.entity.Member;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
final class MemberAuthenticationHolder implements MemberSessionHolder {

    @Override
    public Member current() {
        return ((MemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).member();
    }

}