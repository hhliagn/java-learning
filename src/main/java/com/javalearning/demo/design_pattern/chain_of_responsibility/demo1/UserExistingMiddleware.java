package com.javalearning.demo.design_pattern.chain_of_responsibility.demo1;

public class UserExistingMiddleware extends Middleware{

    private Server server;

    public UserExistingMiddleware(Server server){
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)){
            System.out.println("This email is not registered!");
            return false;
        }

        if (!server.isValidatePassword(email, password)){
            System.out.println("Wrong password!");
            return false;
        }

        return true;
    }
}
