package com.zhao.marketcenter.action;

import com.zhao.marketcenter.action.helper.BaseResponse;

/**
 * 当前请求的上下文容器
 */
public class RequestContext extends Context {
    private static final long serialVersionUID = -1054539809433963262L;

    /**
     * 系统级别的上下文容器
     */
    private AppContext appContext;

    /**
     * 当前请求的请求对象
     */
    private ServerRequest request;

    /**
     * 返回的response对象
     */
    @SuppressWarnings("rawtypes")
    private BaseResponse response;

    /**
     * @param appContext
     * @param request
     */
    public RequestContext(AppContext appContext, ServerRequest request) {
        this.appContext = appContext;
        this.request = request;
    }

    /**
     * @return the appContext
     */
    public AppContext getAppContext() {
        return appContext;
    }

    /**
     * @return the request
     */
    public ServerRequest getRequest() {
        return request;
    }

    /**
     * @return the response
     */
    @SuppressWarnings("rawtypes")
    public BaseResponse getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    @SuppressWarnings("rawtypes")
    public void setResponse(BaseResponse response) {
        this.response = response;
    }
}
