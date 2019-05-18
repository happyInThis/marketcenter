package com.zhao.marketcenter.action;

public enum ActionEnum {

    TEST("test");

    private String actionName;

    ActionEnum(String actionName) {
        this.actionName = actionName;
    }

    public static ActionEnum getActionEnum(String actionName) {
        for(ActionEnum ae : ActionEnum.values()) {
            if(ae.actionName.equals(actionName)) {
                return ae;
            }
        }
        return null;
    }

    public String getActionName() {
        return actionName;
    }
}