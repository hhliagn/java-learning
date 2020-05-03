package com.javalearning.demo.commonmistakes.exception.finallyIssue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FinallyController {

    @GetMapping("/wrong")
    public void wrong(){
        try {
            throw new RuntimeException("try");
        }finally {
            throw new RuntimeException("finally");
        }
    }

    @GetMapping("/right1")
    public void right1(){
        try {
            throw new RuntimeException("try");
        }finally {
            try {
                throw new RuntimeException("finally");
            }catch (Exception e){
                log.error("发生异常", e);
            }
        }
    }

    @GetMapping("/right2")
    public void right2() throws Exception {
        Exception e = null;
        try {
            throw new RuntimeException("try");
        }catch (Exception excepton){
            e = excepton;
        }finally {
            try {
                throw new RuntimeException("finally");
            }catch (Exception ex){
                if (e == null){
                    e = ex;
                }else {
                    e.addSuppressed(ex);
                }
            }
            throw e;
        }
    }

    @GetMapping("/testResourceWrong")
    public void testResourceWrong(){
        TestResource testResource = new TestResource();
        try {
            testResource.read();
        }finally {
            testResource.close();
        }
    }

    @GetMapping("/testResourceRight")
    public void testResourceRight(){
        try (TestResource testResource = new TestResource()) {
            testResource.read();
            System.out.println("xxx");
        }
    }
}
