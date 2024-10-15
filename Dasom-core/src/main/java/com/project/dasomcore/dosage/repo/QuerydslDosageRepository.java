package com.project.dasomcore.dosage.repo;

import com.project.dasomcore.dosage.application.response.DosageRes;

import java.util.List;

public interface QuerydslDosageRepository {
    List<DosageRes> getDosages(Long page, Long size, String year, String month, String date);

    List<DosageRes> getMyDosages(Long page, Long size,Long childId);
}
