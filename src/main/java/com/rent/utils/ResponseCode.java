package com.rent.utils;

public enum ResponseCode {

    //成功标志
    SUCCESS("操作成功", 0),

    //数据库连接错误
    DATABASE_FAIL("服务器错误", 10000),
    DATA_NOT_EXIST("数据不存在", 10001),
    NOT_LOGIN("用户没有登录", 10002),
    NOT_POWER("没有权限", 10003),
    PARAMS_WRONG("请求参数错误", 10004),
    ;


    // 成员变量
    private String msg;
    private int code;

    // 构造方法
    private ResponseCode(String msg, int index) {
        this.msg = msg;
        this.code = index;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return this.msg;
    }

}




