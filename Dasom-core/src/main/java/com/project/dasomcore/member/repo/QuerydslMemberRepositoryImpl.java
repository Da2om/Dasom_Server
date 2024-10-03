package com.project.dasomcore.member.repo;

import com.project.dasomcore.member.domain.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.project.dasomcore.member.domain.entity.QMember.member;

@Repository
@RequiredArgsConstructor
public class QuerydslMemberRepositoryImpl implements QuerydslMemberRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public Member findByUsername(String username) {
        return queryFactory.selectFrom(member)
                .where(member.username.eq(username))
                .fetchFirst();
//        return null;
    }
}
