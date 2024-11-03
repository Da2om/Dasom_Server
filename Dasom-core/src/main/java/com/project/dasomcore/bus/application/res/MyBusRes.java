package com.project.dasomcore.bus.application.res;

import java.time.LocalDateTime;

public record MyBusRes(
        Long busId,
        LocalDateTime boardTime
) {
}
