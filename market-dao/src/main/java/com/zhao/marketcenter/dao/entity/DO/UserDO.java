package com.zhao.marketcenter.dao.entity.DO;


import com.zhao.marketcenter.dao.entity.BaseDO;
import lombok.Data;

@Data
public class UserDO extends BaseDO {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户名
     */
    private Integer age;

}
