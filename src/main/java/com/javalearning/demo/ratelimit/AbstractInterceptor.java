package com.javalearning.demo.ratelimit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public abstract class AbstractInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String result = "";
        try {
            result = preFilter(request);
        } catch (Exception e) {
            log.error("preFilter catch Exception.", e);
            return false;
        }

        if ("OK".equalsIgnoreCase(result)){
            return true;
        }

        handleFail(result, response);
        return false;
    }

    private void handleFail(String result, HttpServletResponse response){

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(result);
        } catch (IOException e) {
            log.error("handleFailError", e);
        }finally {
            if (writer != null) writer.close();
        }


    }

    abstract String preFilter(HttpServletRequest request);
}
