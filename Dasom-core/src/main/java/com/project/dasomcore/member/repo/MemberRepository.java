package com.project.dasomcore.member.repo;

import com.project.dasomcore.member.domain.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String>, QuerydslMemberRepository {
    boolean existsByEmail(String email);
}
