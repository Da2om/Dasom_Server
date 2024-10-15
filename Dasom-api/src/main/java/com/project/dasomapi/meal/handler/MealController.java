package com.project.dasomapi.meal.handler;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.meal.usecase.MealUseCase;
import com.project.dasomapi.meal.usecase.req.RegisterMealReq;
import com.project.dasomcore.meal.application.res.MealRes;
import com.project.dasomcore.meal.application.res.MonthlyMealRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealUseCase mealUseCase;

    @PostMapping("")
    @Operation(summary = "급식 등록 요청", description = "급식 정보를 저장 (teacher)")
    public Response register(
            @RequestBody List<RegisterMealReq> requests
    ){
        return mealUseCase.register(requests);
    }

    @GetMapping("/today")
    @Operation(summary = "오늘 급식 조회", description = "오늘 급식리스트 조회 (authenticated)")
    public ResponseData<List<MealRes>> getTodayMeal() {
        return mealUseCase.getTodayMeal();
    }

    @GetMapping("/{year}/{month}")
    @Operation(summary = "월별 급식 조회", description = "월별 급식리스트 조회 (authenticated)")
    public ResponseData<List<MonthlyMealRes>> getMonthlyMeal(
            @PathVariable("year") String year,
            @PathVariable("month") String month
    ) {
        return mealUseCase.getMonthlyMeal(year,month);
    }

}
