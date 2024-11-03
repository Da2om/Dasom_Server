package com.project.dasomapi.member.usecase.req;

public record ModifyReq(
        String email,
        String username,
        String name,
        Integer classInCharge,
        String pushToken,
        Boolean isOnChattingAlarm,
        Boolean isOnNoticeAlarm
) {
}
