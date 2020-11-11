package com.zhao.marketcenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class UserVO implements Serializable {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户名
     */
    private Integer age;
}
