package com.project.dasomapi.dosage.usecase.req;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.dosage.domain.consts.DosagePeriod;
import com.project.dasomcore.dosage.domain.entity.Dosage;

import java.time.LocalDateTime;

public record RequestDosageReq(
        String medicineName,
        DosagePeriod breakfast,
        DosagePeriod lunch,
        DosagePeriod dinner,
        String description) {
    public Dosage toEntity(Child child){
        return Dosage.builder()
                .medicineName(this.medicineName)
                .breakfast(this.breakfast)
                .lunch(this.lunch)
                .dinner(this.dinner)
                .description(description)
                .createdAt(LocalDateTime.now())
                .child(child).build();
    }
}
