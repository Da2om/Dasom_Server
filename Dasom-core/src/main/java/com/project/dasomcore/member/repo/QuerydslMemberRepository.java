package com.project.dasomcore.member.repo;

import com.project.dasomcore.member.domain.entity.Member;

public interface QuerydslMemberRepository {
    Member findByEmail(String email);
}
