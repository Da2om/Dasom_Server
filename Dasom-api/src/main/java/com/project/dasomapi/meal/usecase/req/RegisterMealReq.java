package com.project.dasomapi.meal.usecase.req;

import com.project.dasomcore.meal.domain.consts.MealType;
import com.project.dasomcore.meal.domain.entity.Meal;
import com.project.dasomcore.member.domain.entity.Member;

import java.time.LocalDate;

public record RegisterMealReq(
        LocalDate date,
        String menu,
        MealType mealType,
        Integer calorie
) {
    public Meal toEntity(Member member) {
        return Meal.builder()
                .date(this.date)
                .menu(this.menu)
                .mealType(this.mealType)
                .calorie(this.calorie)
                .member(member).build();
    }
}
