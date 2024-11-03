package com.project.dasomcore.meal.repo;

import com.project.dasomcore.dosage.application.response.DosageRes;
import com.project.dasomcore.meal.application.res.MealRes;
import com.project.dasomcore.meal.application.res.MonthlyMealRes;
import com.project.dasomcore.meal.domain.entity.QMeal;
import com.project.dasomcore.member.domain.entity.QMember;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.project.dasomcore.meal.domain.entity.QMeal.meal;

@Repository
@RequiredArgsConstructor
public class QuerydslMealRepositoryImpl implements QuerydslMealRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MealRes> getTodayMeals() {
        return queryFactory
                .select(responseProjection())
                .from(meal)
                .where(meal.date.dayOfMonth().eq(LocalDate.now().getDayOfMonth()))
                .fetch();
    }

    @Override
    public List<MonthlyMealRes> getMonthlyMeal(String year, String month) {
        QMeal meal = QMeal.meal;

        return queryFactory
                .select(Projections.constructor(
                        MonthlyMealRes.class,
                        meal.date,
                        Projections.list(
                                responseProjection()
                        )
                ))
                .from(meal)
                .where(meal.date.year().eq(Integer.parseInt(year))
                        .and(meal.date.month().eq(Integer.parseInt(month))))
                .orderBy(meal.date.asc(), meal.mealType.asc())
                .fetch();
    }

    private ConstructorExpression<MealRes> responseProjection(){
        return Projections.constructor(MealRes.class,
                meal.mealId,
                meal.menu,
                meal.mealType,
                meal.calorie
        );
    }
}
