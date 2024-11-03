package com.project.dasomcore.meal.application;

import com.project.dasomcore.meal.application.res.MealRes;
import com.project.dasomcore.meal.application.res.MonthlyMealRes;
import com.project.dasomcore.meal.domain.entity.Meal;
import com.project.dasomcore.meal.repo.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MealService {

    private final MealRepository mealRepository;

    public void save(Meal meal) {
        mealRepository.save(meal);
    }

    public List<MealRes> getTodayMeal() {
        return mealRepository.getTodayMeals();
    }

    public List<MonthlyMealRes> getMonthlyMeal(String year, String month) {
        return mealRepository.getMonthlyMeal(year,month);
    }

}
