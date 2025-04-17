package com.it.common;

import lombok.Data;
import java.util.List;

@Data
public class PageResult<T> {
    private Long total;       // 总记录数（网页6、网页9、网页10均强调此字段）
    private List<T> records; // 当前页数据列表（网页1、网页6、网页10使用此字段名）

    public PageResult(Long total, List<T> records) {
        this.total = total;
        this.records = records;
    }
}