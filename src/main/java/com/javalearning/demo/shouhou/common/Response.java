package com.javalearning.demo.shouhou.common;

public class Response<T> {

    private int code;
    private String message;
    private T data;

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response fail(){
        return new Response(400, "服务繁忙", null);
    }

    public static Response success(){
        return new Response(200, "请求成功", null);
    }
}
