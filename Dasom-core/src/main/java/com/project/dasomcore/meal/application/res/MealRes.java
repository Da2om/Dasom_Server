package com.project.dasomcore.meal.application.res;

import com.project.dasomcore.meal.domain.consts.MealType;

public record MealRes(
        Long mealId,
        String menu,
        MealType mealType,
        Integer calorie
) {
}
