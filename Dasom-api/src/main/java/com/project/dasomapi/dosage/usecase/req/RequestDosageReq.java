package com.project.dasomapi.dosage.usecase.req;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.dosage.domain.entity.Dosage;

import java.time.LocalDateTime;

public record RequestDosageReq(
        String medicineName,
        String dosageTime,
        String breakfast,
        String lunch,
        String dinner,
        String etc) {
    public Dosage toEntity(Child child){
        return Dosage.builder()
                .medicineName(this.medicineName)
                .dosageTime(this.dosageTime)
                .breakfast(this.breakfast)
                .lunch(this.lunch)
                .dinner(this.dinner)
                .etc(this.etc)
                .createdAt(LocalDateTime.now())
                .child(child).build();
    }
}
