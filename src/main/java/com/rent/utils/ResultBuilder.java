package com.rent.utils;

import com.alibaba.fastjson.JSON;

public class ResultBuilder {

    public static String build(Result result) {
        return JSON.toJSONString(result);
    }

    public static String buildResponseCode(ResponseCode code) {
        return build(Result.build(code.getCode(),code.getMsg()));
    }
    public static String buildData(Object object) {
        return build(Result.ok(object));
    }

    public static String buildOk(){
        return build(Result.ok());
    }
    public static String buildOk(String msg){
        return build(Result.ok(msg));
    }
    public static String buildFail(){
        return build(Result.fail());
    }
    public static String buildFail(String msg){
        return build(Result.fail(msg));
    }
}
