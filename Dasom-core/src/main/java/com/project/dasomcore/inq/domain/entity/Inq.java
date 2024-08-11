package com.project.dasomcore.inq.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Table(name = "tbl_inq")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquireId;

    private String title;

    private String content;

    private String fkMemberId;

}
