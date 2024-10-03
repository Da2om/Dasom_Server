package com.project.dasomcore.child.domain.entity;

import com.project.dasomcore.child.domain.consts.BloodType;
import com.project.dasomcore.child.domain.consts.Gender;
import com.project.dasomcore.member.domain.consts.MemberClass;
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

    private String emergencyContactNumber;

    private String imageUrl;

    private MemberClass assignedClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_member_id")
    private Member member;

    public void modify(Child child) {
        this.childName = child.childName;
        this.age = child.age;
        this.cls = child.cls;
        this.gender = child.gender;
        this.birthDt = child.birthDt;
        this.bloodType = child.bloodType;
        this.isDisease = child.isDisease;
        this.emergencyContactNumber = child.emergencyContactNumber;
        this.imageUrl = child.imageUrl;
    }
}