package com.javalearning.demo.commonmistakes.exception.handleexception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @description exception
 * @date 2020/4/27
 */
@Slf4j
@RestController
@RequestMapping("handleexception")
public class HandleExceptionController {

    @GetMapping("exception")
    public void exception(@RequestParam("bussiness") boolean b) throws BussinessException {
        if (b){
            throw new BussinessException("exception",1);
        }else {
            throw new RuntimeException("exception");
        }
    }

    @GetMapping("wrong1")
    public void wrong1(){
        try {
            readFile();
        } catch (IOException e) {
            throw new RuntimeException("系统繁忙请稍后再试。");
        }
    }

    @GetMapping("wrong2")
    public void wrong2(){
        try {
            readFile();
        }catch (IOException e){
            log.error("读取文件错误。。。", e.getMessage());
            throw new RuntimeException("系统繁忙请稍后再试。");
        }
    }

    @GetMapping("wrong3")
    public void wrong3(){
        try {
            readFile();
        } catch (IOException e) {
            log.error("读取文件错误。。。", e);
            throw new RuntimeException();
        }
    }

    @GetMapping("right1")
    public void right1(){
        try {
            readFile();
        } catch (IOException e) {
            log.error("读取文件失败。。。",e);
            throw new RuntimeException("系统繁忙请稍后再试。");
        }
    }

    @GetMapping("right2")
    public void right2(){
        try {
            readFile();
        } catch (IOException e) {
            throw new RuntimeException("系统繁忙请稍后再试。", e);
        }
    }

    private void readFile() throws IOException {
        Files.readAllLines(Paths.get("a_file"));
    }

}
