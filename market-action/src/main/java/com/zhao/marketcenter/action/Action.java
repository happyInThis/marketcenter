package com.zhao.marketcenter.action;

import com.zhao.marketcenter.action.helper.BaseResponse;
import com.zhao.marketcenter.common.exception.ServerException;

public interface Action {

    BaseResponse execute(RequestContext context) throws ServerException;

    String getName();
}