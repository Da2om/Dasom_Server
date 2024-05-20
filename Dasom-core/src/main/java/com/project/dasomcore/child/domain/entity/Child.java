package com.project.dasomcore.child.domain.entity;

import com.project.dasomcore.child.domain.consts.BloodType;
import com.project.dasomcore.child.domain.consts.Gender;
import com.project.dasomcore.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "tbl_child")
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childId;

    private String childName;

    private Integer age;

    private String cls;

    private Gender gender;

    private LocalDate birthDt;

    private BloodType bloodType;

    private Boolean isDisease;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_member_id", unique = true)
    private Member member;
}
