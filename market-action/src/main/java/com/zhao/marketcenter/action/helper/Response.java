package com.zhao.marketcenter.action.helper;

import java.io.Serializable;


public interface Response<T> extends Serializable {
    public T getModule();

    public int getCode();

    public String getMsg();

    public long getTotalCount();

    public boolean isSuccess();
}