package com.project.dasomcore.member.application;

import com.project.dasomcore.member.domain.entity.Member;

public interface MemberSessionHolder {
    Member current();
}
