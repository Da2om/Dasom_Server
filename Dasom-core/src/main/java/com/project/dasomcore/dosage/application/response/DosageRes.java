package com.project.dasomcore.dosage.application.response;

public record DosageRes(
        Long dosageId,
        String medicineName,
        String breakfast,
        String lunch,
        String dinner,
        String description,
        Long childId,
        String childName,
        String imageUrl
) {
}
