package com.hyunjin.firstcome_system.order.order.dto.response.read;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderMainResponse {
    private List<OrderMainItem> items;
    private String nextCursor;
    private long totalCount;
}
