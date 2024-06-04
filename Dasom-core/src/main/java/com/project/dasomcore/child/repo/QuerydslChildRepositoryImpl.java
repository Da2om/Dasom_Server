package com.project.dasomcore.child.repo;

import com.project.dasomcore.child.application.ChildRes;
import com.project.dasomcore.child.application.MyChildInfoRes;
import com.project.dasomcore.child.domain.consts.BloodType;
import com.project.dasomcore.child.domain.consts.Gender;
import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.domain.entity.Member;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.project.dasomcore.child.domain.entity.QChild.child;

@Repository
@RequiredArgsConstructor
@Transactional
public class QuerydslChildRepositoryImpl implements QuerydslChildRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<MyChildInfoRes> findMyChildByMember(Member member) {
        return queryFactory.select(
                Projections.constructor(MyChildInfoRes.class,
                        child.childId,
                        child.childName,
                        child.cls,
                        child.birthDt)
                ).from(child)
                .where(child.member.eq(member))
                .fetch();
    }

    @Override
    public List<ChildRes> findList(Long page, Long size) {
        return queryFactory
                .select(responseProjection())
                .from(child)
                .offset((page - 1) * size)
                .limit(size)
                .fetch();
    }

    private ConstructorExpression<ChildRes> responseProjection(){
        Projections.constructor(ChildRes.class,
                child.childId,
                child.childName
                child.age,
                child.cls,
                child.gender,
                child.birthDt,
                child.bloodType,
                child.isDisease
        )
    }
}