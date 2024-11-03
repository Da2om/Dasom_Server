package com.project.dasomcore.meal.application.res;

import java.time.LocalDate;
import java.util.List;

public record MonthlyMealRes(LocalDate date, List<MealRes> meal) {
}