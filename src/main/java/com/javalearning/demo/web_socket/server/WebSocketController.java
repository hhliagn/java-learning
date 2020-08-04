package com.javalearning.demo.web_socket.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.concurrent.TimeUnit;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public SendMsg greeting(ReceiveMsg receiveMsg) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return new SendMsg("Hello, " + HtmlUtils.htmlEscape(receiveMsg.getContent()));
    }
}
