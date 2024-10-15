package com.project.dasomcore.meal.repo;

import com.project.dasomcore.meal.domain.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Long>,QuerydslMealRepository {
}
