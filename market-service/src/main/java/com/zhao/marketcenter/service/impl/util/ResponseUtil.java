package com.zhao.marketcenter.service.impl.util;

import com.zhao.marketcenter.client.BaseResponse;
import com.zhao.marketcenter.client.ResponseCode;
import com.zhao.marketcenter.common.exception.ServerException;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static <T> BaseResponse<T> getSuccessResponse(T model) {
        BaseResponse res = new BaseResponse(model);
        res.setCode(ResponseCode.RESPONSE_SUCCESS.getCode());
        res.setMsg(ResponseCode.RESPONSE_SUCCESS.getComment());
        return res;
    }

    public static BaseResponse getSuccessResponse() {
        BaseResponse res = new BaseResponse();
        res.setCode(ResponseCode.RESPONSE_SUCCESS.getCode());
        res.setMsg(ResponseCode.RESPONSE_SUCCESS.getComment());
        return res;
    }

    public static BaseResponse getErrorResponse(ResponseCode responseCode) {
        return new BaseResponse(responseCode);
    }

    public static BaseResponse getErrorResponse(ResponseCode responseCode, String message) {
        return new BaseResponse(responseCode, message);
    }

    public static BaseResponse getErrorResponse(ServerException e) {
        return new BaseResponse(e.getResponseCode(), e.getMessage());
    }

    public static BaseResponse getErrorResponse(int code, String message) {
        return new BaseResponse(code, message);
    }

    public static <T> BaseResponse getSuccessResponse(T model, long totalCount) {
        BaseResponse res = new BaseResponse(model);
        res.setCode(ResponseCode.RESPONSE_SUCCESS.getCode());
        res.setMsg(ResponseCode.RESPONSE_SUCCESS.getComment());
        res.setTotalCount(totalCount);
        return res;
    }

    public static Map<String, Object> getResData(String key, Object value) {
        Map<String, Object> resData = new HashMap<String, Object>();
        resData.put(key, value);
        return resData;
    }

    public static BaseResponse getBaseResponse(BaseResponse response) {
        BaseResponse baseResponse = new BaseResponse(response.getData());
        baseResponse.setCode(response.getCode());
        baseResponse.setMsg(response.getMsg());
        baseResponse.setTotalCount(response.getTotalCount());
        return baseResponse;
    }
}
