package com.javalearning.demo.test.exceptions.test1;

public class MyException extends Exception {
    private String args;

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public MyException(){
        super();
    }
    public MyException(String args){
        super(args);
        this.args = args;
    }
}
