package com.project.dasomcore.meal.domain.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MealType {
    SNACK("간식"),
    BREAKFAST("아침"),
    LUNCH("점심"),
    DINNER("저녁");

    private final String desc;
}
