package com.project.dasomapi.bus.usecase.req;

import java.time.LocalDateTime;

public record ModifyBusReq(
        LocalDateTime boardTime,
        boolean isBoard
) {
}
