package com.javalearning.demo.test.finalize;

public class Tank {

    boolean isEmpty = true;
    Tank(boolean isEmpty){
        this.isEmpty = isEmpty;
    }
    void drop(){
        this.isEmpty = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (isEmpty) System.out.println("ERROR: Tank is not empty.");
        super.finalize();
    }
}
