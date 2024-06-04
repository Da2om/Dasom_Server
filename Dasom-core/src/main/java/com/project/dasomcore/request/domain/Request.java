package com.project.dasomcore.request.domain;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.request.domain.consts.MedicineTime;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Table(name = "tbl_request")
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String medicine;

    private MedicineTime typeOnMorning;

    private MedicineTime typeOnLunch;

    private MedicineTime typeOnDinner;

    @Column(columnDefinition = "TEXT")
    private String etc;

    @ManyToOne
    @JoinColumn(name = "child")
    private Child child;
}
