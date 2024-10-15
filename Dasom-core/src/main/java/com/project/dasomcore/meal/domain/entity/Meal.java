package com.project.dasomcore.meal.domain.entity;

import com.project.dasomcore.meal.domain.consts.MealType;
import com.project.dasomcore.member.domain.entity.Member;
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
import org.apache.catalina.User;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "tbl_meal")
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealId;

    private LocalDate date;

    private String menu;

    @Enumerated(EnumType.STRING)
    private MealType mealType;

    private Integer calorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_writer_id")
    private Member member;

}
