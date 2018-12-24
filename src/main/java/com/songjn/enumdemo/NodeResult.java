package com.songjn.enumdemo;

public enum NodeResult {
    NODE_SUC(0), NODE_EXIST(1), CREATE_FAIL(-1), PAREANT_NOEXIST(-2);
    private int code;

    private NodeResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
