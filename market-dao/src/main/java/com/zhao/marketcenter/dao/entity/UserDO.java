package com.zhao.marketcenter.dao.entity;


import com.zhao.marketcenter.dao.BaseDO;
import lombok.Data;

@Data
public class UserDO extends BaseDO {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 订单流水号
     */
    private String orderSn;

}
