package com.zhao.marketcenter.action;

public enum ActionEnum {

    C_QUERY_USER("cQueryUser"),
    C_GET_USER("cGETUser"),
    C_ADD_USER("cAddUser");

    private String actionName;

    ActionEnum(String actionName) {
        this.actionName = actionName;
    }

    public static ActionEnum getActionEnum(String actionName) {
        for (ActionEnum ae : ActionEnum.values()) {
            if (ae.actionName.equals(actionName)) {
                return ae;
            }
        }
        return null;
    }

    public String getActionName() {
        return actionName;
    }
}