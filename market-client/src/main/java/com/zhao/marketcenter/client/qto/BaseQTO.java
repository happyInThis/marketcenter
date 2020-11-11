package com.zhao.marketcenter.client.qto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseQTO implements Serializable {
    public static final int MAX_COUNT = 500;
    /**
     * 偏移位置
     */
    private int offset = 0;
    /**
     * 查询记录条数
     */
    private int count = 100;

    /**
     * 根据指定字段正序排列
     */
    private String orderByAsc;

    /**
     * 根据指定字段倒序排列
     */
    private String orderByDesc;
}
