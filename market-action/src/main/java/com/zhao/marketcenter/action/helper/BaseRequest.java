package com.zhao.marketcenter.action.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseRequest implements Request {
    private static final long serialVersionUID = -5466899657256730640L;
    private final Map<String, Object> attrs = new HashMap<>();
    private String command;
    private Map<String, Object> params = new HashMap<>(8);

    public BaseRequest() {
    }

    public BaseRequest(String command) {
        this.command = command;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public Set<String> getParamNames() {
        return params.keySet();
    }

    @Override
    public Object getParam(String key) {
        return params.get(key);
    }

    @Override
    public void setParam(String key, Object value) {
        params.put(key, value);
    }

    /**
     * @param key
     * @param value
     */
    public void setAttribute(String key, Object value) {
        attrs.put(key, value);
    }

    /**
     * @param key
     * @return
     */
    public Object getAttribte(String key) {
        return attrs.get(key);
    }
}
