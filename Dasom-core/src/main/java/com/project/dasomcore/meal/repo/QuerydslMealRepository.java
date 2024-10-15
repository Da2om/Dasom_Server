package com.project.dasomcore.meal.repo;

import com.project.dasomcore.meal.application.res.MealRes;
import com.project.dasomcore.meal.application.res.MonthlyMealRes;

import java.util.List;

public interface QuerydslMealRepository {
    List<MealRes> getTodayMeals();

    List<MonthlyMealRes> getMonthlyMeal(String year, String month);
}
