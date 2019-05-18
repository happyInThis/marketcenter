package com.zhao.marketcenter.service;

import com.zhao.marketcenter.action.RequestAdapter;
import com.zhao.marketcenter.action.RequestDispatcher;
import com.zhao.marketcenter.action.helper.Request;
import com.zhao.marketcenter.action.helper.Response;

import javax.annotation.Resource;


public class BaseService {
    @Resource
    private RequestDispatcher requestDispatcher;

    /**
     * 服务端接口执行
     **/
    protected Response execute(Request request) {
        // 代理基础的request
        Response response = requestDispatcher.dispatch(new RequestAdapter(request));
        return response;
    }
}