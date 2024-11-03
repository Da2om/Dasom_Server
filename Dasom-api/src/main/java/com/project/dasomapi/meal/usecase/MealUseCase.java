package com.project.dasomapi.meal.usecase;

import com.project.dasomapi.common.Response;
import com.project.dasomapi.common.ResponseData;
import com.project.dasomapi.meal.usecase.req.RegisterMealReq;
import com.project.dasomcore.meal.application.MealService;
import com.project.dasomcore.meal.application.res.MealRes;
import com.project.dasomcore.meal.application.res.MonthlyMealRes;
import com.project.dasomcore.member.application.MemberService;
import com.project.dasomcore.member.application.MemberSessionHolder;
import com.project.dasomcore.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MealUseCase {

    private final MealService mealService;
    private final MemberSessionHolder memberSessionHolder;

    public Response register(List<RegisterMealReq> requests) {
        Member member = memberSessionHolder.current();
        for(RegisterMealReq req : requests) {
            mealService.save(req.toEntity(member));
        }
        return Response.created("급식 저장 성공");
    }

    public ResponseData<List<MealRes>> getTodayMeal() {
        List<MealRes> res = mealService.getTodayMeal();
        return ResponseData.ok("오늘 급식 조회 성공",res);
    }

    public ResponseData<List<MonthlyMealRes>> getMonthlyMeal(String year, String month) {
        List<MonthlyMealRes> res = mealService.getMonthlyMeal(year, month);
        return ResponseData.ok("월별 급식 조회 성공",res);
    }
}
