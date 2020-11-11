package com.zhao.marketcenter.client;

public enum ResponseCode {
    RESPONSE_SUCCESS(10000, "success"),
    //参数错误
    PARAM_E_ACTION_NOT_EXIST(20001, "the action does not exist"),
    SYSTEM_EXCEPTION(20002, "system exception");

    private Integer code;
    private String comment;

    private ResponseCode(Integer code, String comment) {
        this.code = code;
        this.comment = comment;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getComment() {
        return this.comment;
    }
}