//package com.javalearning.demo1.complex_pojo.controller;
//
//import com.javalearning.demo1.complex_pojo.bean.News;
//import com.javalearning.demo1.complex_pojo.service.NewsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@RequestMapping("/cc")
//@RestController
//public class NewsController {
//
//    @Autowired
//    private NewsService newsService;
//
//    @PostMapping("/insert")
//    public void insert() throws IOException {
//        newsService.insert();
//    }
//
//    @GetMapping("/get")
//    public News get(int id) throws IOException {
//        return newsService.get(id);
//    }
//}
