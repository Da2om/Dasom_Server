package com.project.dasomcore.bus.repo;

import com.project.dasomcore.bus.application.res.BusRes;
import com.project.dasomcore.bus.application.res.MyBusRes;
import com.project.dasomcore.bus.domain.entity.Bus;
import com.project.dasomcore.meal.application.res.MealRes;
import com.project.dasomcore.member.domain.entity.Member;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.dasomcore.bus.domain.entity.QBus.bus;
import static com.project.dasomcore.meal.domain.entity.QMeal.meal;

@Repository
@RequiredArgsConstructor
public class QuerydslBusRepositoryImpl implements QuerydslBusRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MyBusRes> getMyBus(Member member) {
        return queryFactory
                .select(Projections.constructor(MyBusRes.class,
                    bus.busId,
                    bus.boardTime
                ))
                .from(bus)
                .where(bus.member.eq(member))
                .fetch();
    }

    @Override
    public List<BusRes> getBusList() {
        return queryFactory
                .select(responseProjection())
                .from(bus)
                .where(bus.modifiedDt.isNull())
                .fetch();
    }

    @Override
    public List<BusRes> getModifiedBusList() {
        return queryFactory
                .select(responseProjection())
                .from(bus)
                .where(bus.modifiedDt.isNotNull())
                .fetch();
    }

    private ConstructorExpression<BusRes> responseProjection(){
        return Projections.constructor(BusRes.class,
                bus.busId,
                bus.boardTime,
                bus.isBoard,
                bus.child.childName,
                bus.child.assignedClass
        );
    }

}
