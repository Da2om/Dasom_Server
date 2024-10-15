package com.project.dasomcore.inq.domain.entity;

import com.project.dasomcore.member.domain.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_writer_id")
    private Member member;

}
