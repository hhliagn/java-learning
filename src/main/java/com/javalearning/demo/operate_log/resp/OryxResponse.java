package com.javalearning.demo.operate_log.resp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by phil on 3/15/19.
 * @author phil
 */
public class OryxResponse<T> {

    private Integer code;
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LogContent logContent;

    public OryxResponse() {}

    public OryxResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public OryxResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    public static <T> OryxResponse<T> success() {
        return new OryxResponse<T>(0, "ok");
    }

    @JsonIgnore
    public static <T> OryxResponse<T> success(String msg) {
        return new OryxResponse<T>(0, msg);
    }

    @JsonIgnore
    public static <T> OryxResponse<T> success(T data) {
        return new OryxResponse<T>(0, "ok", data);
    }

    @JsonIgnore
    public static <T> OryxResponse<T> success(String msg, T data) {
        return new OryxResponse<>(0, msg, data);
    }

    @JsonIgnore
    public static <T> OryxResponse<T> successData(T data) {
        return new OryxResponse<>(0, "", data);
    }

    public interface IPageAdapter<E> {
        long getTotal();
        int getPages();
        List<E> getData();
    }

    @JsonIgnore
    public static <T> OryxResponse<T> fail(Integer code, String msg) {
        return fail(code, msg, null);
    }

    @JsonIgnore
    public static <T> OryxResponse<T> fail(Integer code, String msg, T data) {
        return new OryxResponse<T>(code, msg, data);
    }

    @JsonIgnore
    public boolean isSuccessful() {
        return code == 0;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OryxResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }


    /**
     * 日志内容类
     */
    public static class LogContent {

        private String content;

        private Integer order;

        private LogContent(String content) {
            this.content = content;
        }

        public LogContent(String content, Integer order) {
            this.content = content;
            this.order = order;
        }

        public Integer getOrder() {
            return order;
        }

        public String getContent() {
            return content;
        }

        public static LogContent build(String content){
            if(content == null) {
                content = "";
            }
            return new LogContent(content);
        }

        public static LogContent build(String content, Integer order){
            if(content == null) {
                content = "";
            }

            if(null == order) {
                order = 0;
            }

            return new LogContent(content, order);
        }
    }

    public LogContent getLogContent() {
        return logContent;
    }

    public void setLogContent(LogContent logContent) {
        this.logContent = logContent;
    }

    public OryxResponse(Integer code, String msg, T data, LogContent logContent) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.logContent = logContent;
    }

    @JsonIgnore
    public static <T> OryxResponse<T> success(LogContent logContent) {
        return new OryxResponse<>(0, "ok", null, logContent);
    }

    @JsonIgnore
    public static <T> OryxResponse<T> success(T data, LogContent logContent) {
        return new OryxResponse<>(0, "ok", data, logContent);
    }


}
