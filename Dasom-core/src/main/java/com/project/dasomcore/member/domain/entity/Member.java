package com.project.dasomcore.member.domain.entity;

import com.project.dasomcore.member.domain.consts.MemberRole;
import com.project.dasomcore.member.domain.consts.MemberState;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Table(name = "tbl_member")
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    private String email;

    private String pw;

    private String name;

    private String tel;

    @Enumerated(EnumType.STRING)
    private MemberState state;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Column(columnDefinition = "TEXT")
    private String pushToken;

    private Boolean isOnChattingAlarm;

    private Boolean isOnNoticeAlarm;
}
