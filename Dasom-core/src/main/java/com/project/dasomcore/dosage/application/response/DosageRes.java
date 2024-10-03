package com.project.dasomcore.dosage.application.response;

public record DosageRes(
        String medicineName,
        String dosageTime,
        String breakfast,
        String lunch,
        String dinner,
        String etc,
        Long childId,
        String name,
        String imageUrl
) {
}
