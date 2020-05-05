package com.javalearning.demo.commonmistakes.exception.finallyissue;

import com.javalearning.demo.commonmistakes.exception.finallyIssue.TestResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("finallyissue")
public class FinallyIssueController {

    @GetMapping("wrong1")
    public void wrong1(){
        try {
            log.info("try");
            throw new RuntimeException("try");
        }finally {
            log.info("finally");
            throw new RuntimeException("finally");
        }
    }

    @GetMapping("right1")
    public void right1(){
        try {
            log.info("try");
            throw new RuntimeException("try");
        }finally {
            log.info("finally");
            try {
                throw new RuntimeException("finally");
            }catch (Exception e){
                log.error("finally", e);
            }
        }
    }

    @GetMapping("right2")
    public void right2() throws Exception {
        Exception e = null;
        try {
            log.info("try");
            throw new RuntimeException("try");
        }catch (Exception ex){
            e = ex;
        }finally {
            log.info("finally");
            try {
                throw new RuntimeException("finally");
            }catch (Exception e1){
                if (e != null){
                    e.addSuppressed(e1);
                }else {
                    e = e1;
                }
            }
        }
        throw e;
    }

    @GetMapping("closeResourceWrong")
    public void closeResourceWrong() throws Exception {
        TestResource testResource = new TestResource();
        try {
            testResource.read();
        }finally {
            testResource.close();
        }
    }

    @GetMapping("closeResourceRight")
    public void closeResourceRight() throws Exception{
        try (TestResource testResource = new TestResource()){
            testResource.read();
        }
    }

}
