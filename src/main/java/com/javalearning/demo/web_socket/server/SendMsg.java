package com.javalearning.demo.web_socket.server;

import lombok.Data;

@Data
public class SendMsg {

    private String content;

    public SendMsg(String content) {
        this.content = content;
    }
}
