package com.javalearning.demo.ratelimit;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RateLimitHandlerInterceptor extends AbstractInterceptor {

    private RateLimiter rateLimiter = RateLimiter.create(1);

    @Override
    String preFilter(HttpServletRequest request) {
        if (rateLimiter.tryAcquire()){
            return "OK";
        }else {
            return "访问受限!";
        }
    }
}
