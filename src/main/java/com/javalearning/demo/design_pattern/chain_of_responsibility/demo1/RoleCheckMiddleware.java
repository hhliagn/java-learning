package com.javalearning.demo.design_pattern.chain_of_responsibility.demo1;

public class RoleCheckMiddleware extends Middleware{

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")){
            System.out.println("Hello Admin!");
            return true;
        }else {
            System.out.println("Hello User!");
            return checkNext(email, password);
        }
    }
}
