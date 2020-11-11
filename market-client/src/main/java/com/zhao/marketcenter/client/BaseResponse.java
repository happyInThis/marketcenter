package com.zhao.marketcenter.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 8295766534182699773L;

    private T data;
    private int code;
    private String msg;
    private long totalCount = 0;

    public BaseResponse(ResponseCode responseCode, String msg) {
        this.code = responseCode.getCode();
        this.msg = msg;
    }

    public BaseResponse(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getComment();
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 只有当data是集合类型时候才需要将集合大小赋值给totalCount字段
     *
     * @param data
     */
    public BaseResponse(T data) {
        this.data = data;
        this.code = ResponseCode.RESPONSE_SUCCESS.getCode();
        this.msg = ResponseCode.RESPONSE_SUCCESS.getComment();
    }

    public BaseResponse() {
        this.code = ResponseCode.RESPONSE_SUCCESS.getCode();
        this.msg = ResponseCode.RESPONSE_SUCCESS.getComment();
    }

    public boolean isSuccess() {
        return ResponseCode.RESPONSE_SUCCESS.getCode().equals(code);
    }

    @Override
    public String toString() {
        return "code : " + this.code + " msg: " + this.msg + " totalCount: " + this.totalCount + "data : " + this.data;
    }
}