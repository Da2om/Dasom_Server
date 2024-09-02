package com.project.dasomcore.child.application;

import java.time.LocalDate;

public record MyChildInfoRes(
        Long childId,
        String childName,
        String cls,
        LocalDate birthDt
) {
}