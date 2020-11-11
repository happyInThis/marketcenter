package com.zhao.marketcenter.client.qto;


import lombok.Data;

@Data
public class UserQTO extends BaseQTO {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户名
     */
    private Integer age;
}
