package com.javalearning.demo.commonmistakes.exception.finallyIssue;

public class TestResource implements AutoCloseable {

    public void read() {
        throw new RuntimeException("read");
    }

    @Override
    public void close() {
        throw new RuntimeException("close");
    }
}
