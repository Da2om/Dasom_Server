package com.project.dasomapi.common.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record PageRequest(int page,int size) {
}
