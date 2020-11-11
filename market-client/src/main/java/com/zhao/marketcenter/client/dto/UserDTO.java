package com.zhao.marketcenter.client.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userName;
    private Integer age;
    private String mobile;
}
