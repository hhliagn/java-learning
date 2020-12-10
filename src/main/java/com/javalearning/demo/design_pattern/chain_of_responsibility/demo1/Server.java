package com.javalearning.demo.design_pattern.chain_of_responsibility.demo1;

import java.util.HashMap;
import java.util.Map;

public class Server {

    private static Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidatePassword(String email, String password) {
        return password.equals(users.get(email));
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)){
            System.out.println("Authorization has been successful!");
            return true;
        }else {
            return false;
        }
    }
}
