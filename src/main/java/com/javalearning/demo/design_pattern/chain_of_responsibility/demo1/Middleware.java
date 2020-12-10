package com.javalearning.demo.design_pattern.chain_of_responsibility.demo1;

public abstract class Middleware {

    private Middleware next;

    public abstract boolean check(String email, String password);

    public Middleware linkWith(Middleware next){
        this.next = next;
        return this.next;
    }

    public boolean checkNext(String email, String password){
        if (next != null){
            return next.check(email, password);
        }

        return true;
    }
}
