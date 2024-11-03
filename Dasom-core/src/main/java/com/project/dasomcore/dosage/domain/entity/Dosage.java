package com.project.dasomcore.dosage.domain.entity;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.dosage.domain.consts.DosagePeriod;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "tbl_dosage")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dosage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dosageId;

    private String medicineName;

    @Enumerated(EnumType.STRING)
    private DosagePeriod breakfast;

    @Enumerated(EnumType.STRING)
    private DosagePeriod lunch;

    @Enumerated(EnumType.STRING)
    private DosagePeriod dinner;

    private String description;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_child_id")
    private Child child;

}
