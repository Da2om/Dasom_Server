package com.project.dasomcore.bus.domain.entity;

import com.project.dasomcore.child.domain.entity.Child;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "tbl_bus")
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    private LocalDateTime boardTime;

    private boolean isBoard;

    private LocalDateTime modifiedDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_writer_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_child_id")
    private Child child;

    public void update(LocalDateTime localDateTime, boolean board) {
        this.boardTime = localDateTime;
        this.isBoard = board;
        this.modifiedDt = LocalDateTime.now();
    }
}
