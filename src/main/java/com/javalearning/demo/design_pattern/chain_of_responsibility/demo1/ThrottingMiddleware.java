package com.javalearning.demo.design_pattern.chain_of_responsibility.demo1;

public class ThrottingMiddleware extends Middleware{

    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottingMiddleware(int requestPerMinute){
        this.requestPerMinute = requestPerMinute;
        currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(String email, String password) {
        // 1分钟限制流量
        if (System.currentTimeMillis() > currentTime + 60_000){
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request ++;

        if (request > requestPerMinute){
            System.out.println("request limit exceed!");
            return false;
        }

        return true;
    }
}
