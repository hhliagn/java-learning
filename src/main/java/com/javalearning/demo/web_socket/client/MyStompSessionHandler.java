package com.javalearning.demo.web_socket.client;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.util.concurrent.atomic.AtomicReference;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private AtomicReference<Throwable> fail;

    public MyStompSessionHandler(AtomicReference<Throwable> fail){
        this.fail = fail;
    }

    @Override
    public void handleException(StompSession stompSession, StompCommand stompCommand, StompHeaders stompHeaders, byte[] bytes, Throwable throwable) {
        this.fail.set(throwable);
    }

    @Override
    public void handleTransportError(StompSession stompSession, Throwable throwable) {
        this.fail.set(throwable);
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
        this.fail.set(new Exception(stompHeaders.toString()));
    }
}
