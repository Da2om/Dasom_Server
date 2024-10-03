package com.project.dasomcore.notice.repo;

import com.project.dasomcore.child.domain.entity.Child;
import com.project.dasomcore.member.domain.consts.MemberClass;
import com.project.dasomcore.member.domain.entity.Member;
import com.project.dasomcore.notice.application.response.MyClassNoticeListRes;
import com.project.dasomcore.notice.application.response.MyNoticeListRes;
import com.project.dasomcore.notice.application.response.NoticeInfoRes;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.dasomcore.notice.domain.entity.QNotice.notice;
import static com.project.dasomcore.notice.domain.entity.QNoticeFile.noticeFile;
import static com.project.dasomcore.notice.domain.entity.QNoticeImage.noticeImage;

@Repository
@RequiredArgsConstructor
public class QuerydslNoticeRepositoryImpl implements QuerydslNoticeRepository {

    private final JPAQueryFactory query;


    @Override
    public NoticeInfoRes noticeInfo(Long noticeId) {
        // Image와 File의 경로를 가져오기 위한 서브쿼리
        List<String> imageUrls = query.select(noticeImage.url)
                .from(noticeImage)
                .where(noticeImage.notice.eq(notice))
                .fetch();

        List<String> fileUrls = query.select(noticeFile.url)
                .from(noticeFile)
                .where(noticeFile.notice.eq(notice))
                .fetch();

        // 기본적인 Notice와 Member 정보를 가져오는 메인 쿼리
        return query.select(Projections.constructor(NoticeInfoRes.class,
                        notice.title,
                        notice.content,
                        notice.writtenDt,
                        notice.member.name,
                        // 추가적으로 서브쿼리로 가져온 이미지 및 파일 URL 리스트를 넘겨줌
                        Expressions.constant(imageUrls),
                        Expressions.constant(fileUrls)
                ))
                .from(notice)
                .where(notice.noticeId.eq(noticeId))  // 해당 공지사항 ID로 필터링
                .fetchOne();
    }

    @Override
    public List<MyNoticeListRes> getMyNotices(Long page, Long size,Child child) {
        return query.select(Projections.constructor(MyNoticeListRes.class,
                notice.noticeId,
                notice.title,
                notice.writtenDt,
                notice.member.name))
                .from(notice)
                .where(notice.member.classInCharge.eq(child.getAssignedClass())
                        .or(notice.sharingChild.eq(child)))
                .offset((page - 1) * size)
                .limit(size)
                .orderBy(notice.noticeId.desc())
                .fetch();
    }

    @Override
    public List<MyClassNoticeListRes> getMyClassNotices(Long page, Long size, MemberClass myClass) {
        return query.select(Projections.constructor(MyClassNoticeListRes.class,
                        notice.noticeId,
                        notice.title))
                .from(notice)
                .where(notice.member.classInCharge.eq(myClass))
                .offset((page - 1) * size)
                .limit(size)
                .orderBy(notice.noticeId.desc())
                .fetch();
    }


}
