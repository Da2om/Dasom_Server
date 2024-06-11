package com.project.dasomcore.notice.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.project.dasomcore.notice.domain.QFile.file;

@Repository
@RequiredArgsConstructor
public class CustomFileRepoImpl implements CustomFileRepo {

    private final JPAQueryFactory queryFactory;

}
