package com.project.dasomcore.notice.domain.entity;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.notice.domain.consts.ShareScope;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@SuperBuilder
@Table(name = "tbl_notice")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    private String title;

    private String content;

    @Column(nullable = false)
    private LocalDateTime writtenDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_member_id")
    private Member member;

    private ShareScope shareScope;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_share_child_id")
    private Child sharingChild;

    public void update(String title, String content, ShareScope shareScope,Child child) {
        this.title = title;
        this.content = content;
        this.shareScope = shareScope;
        this.sharingChild = child;
    }
}
