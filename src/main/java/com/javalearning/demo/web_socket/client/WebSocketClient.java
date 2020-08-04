package com.javalearning.demo.web_socket.client;

import com.javalearning.demo.web_socket.server.ReceiveMsg;
import com.javalearning.demo.web_socket.server.SendMsg;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/client")
public class WebSocketClient {

    @Value("${server.port}")
    private Integer port;

    private SockJsClient sockJsClient;

    private WebSocketStompClient webSocketStompClient;

    private WebSocketHttpHeaders headers = new WebSocketHttpHeaders();

    @PostConstruct
    public void init(){
        List<Transport> transportList = new ArrayList<>();
        transportList.add(new WebSocketTransport(new StandardWebSocketClient()));
        this.sockJsClient = new SockJsClient(transportList);

        this.webSocketStompClient = new WebSocketStompClient(sockJsClient);
        this.webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());
    }

    @GetMapping("/greet")
    public String greeting() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference<Throwable> fail = new AtomicReference<>();

        StompSessionHandler myStompSessionHandler = new MyStompSessionHandler(fail){

            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                session.subscribe("/topic/greetings", new StompFrameHandler() {

                    @Override
                    public Type getPayloadType(StompHeaders stompHeaders) {
                        return ReceiveMsg.class;
                    }

                    @Override
                    public void handleFrame(StompHeaders stompHeaders, Object o) {
                        ReceiveMsg receiveMsg = (ReceiveMsg) o;
                        System.out.println(receiveMsg.getContent());
                        try {
                            Assert.assertEquals("Spring", receiveMsg.getContent());
                        } catch (Exception e) {
                            fail.set(e);
                        }finally {
                            session.disconnect();
                            countDownLatch.countDown();
                        }
                    }
                });

                try {
                    session.send("/app/hello", new SendMsg("Spring"));
                } catch (Exception e) {
                    fail.set(e);
                }finally {
                    countDownLatch.countDown();
                }
            }
        };

        this.webSocketStompClient.connect(
                "ws://localhost:{port}/my-websocket",
                this.headers,
                myStompSessionHandler,
                this.port);

        if (countDownLatch.await(3, TimeUnit.SECONDS)){
            if (fail.get() != null){
                throw new AssertionError("", fail.get());
            }
        }else {
            Assert.fail("Greeting not receive");
        }

        return "ok";
    }

}
