package com.project.dasomcore.dosage.repo;

import com.project.dasomcore.dosage.application.response.DosageRes;
import com.project.dasomcore.dosage.domain.consts.DosagePeriod;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.dasomcore.dosage.domain.entity.QDosage.dosage;

@Repository
@RequiredArgsConstructor
public class QuerydslDosageRepositoryImpl implements QuerydslDosageRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<DosageRes> getDosages(Long page, Long size, String year, String month, String date) {
        return queryFactory
                .select(responseProjection())
                .from(dosage)
                .where(dosage.createdAt.year().eq(Integer.parseInt(year))
                        .and(dosage.createdAt.month().eq(Integer.parseInt(month)))
                        .and(dosage.createdAt.dayOfMonth().eq(Integer.parseInt(date))))
                .offset((page - 1) * size)
                .limit(size)
                .fetch();
    }

    @Override
    public List<DosageRes> getMyDosages(Long page,Long size,Long childId) {
        return queryFactory
                .select(responseProjection())
                .from(dosage)
                .where(dosage.child.childId.eq(childId))
                .offset((page -1)*size)
                .limit(size)
                .fetch();
    }

    private ConstructorExpression<DosageRes> responseProjection(){
        return Projections.constructor(DosageRes.class,
                dosage.dosageId,
                dosage.medicineName,
                dosage.breakfast,
                dosage.lunch,
                dosage.dinner,
                dosage.description,
                dosage.child.childId,
                dosage.child.childName,
                dosage.child.imageUrl
        );
    }
}
