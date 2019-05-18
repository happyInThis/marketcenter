package com.zhao.marketcenter.action.util;

import com.zhao.marketcenter.action.ActionEnum;
import com.zhao.marketcenter.action.helper.BaseRequest;
import com.zhao.marketcenter.action.helper.Request;

public class RequestUtil {
    public static Request genRequest(ActionEnum command) {
        Request request = new BaseRequest();
        request.setCommand(command.getActionName());
        return request;
    }
}
