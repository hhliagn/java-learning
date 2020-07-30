package com.javalearning.demo.redis.springDataRedis.controller;

import lombok.extern.slf4j.Slf4j;
import com.javalearning.demo.redis.springDataRedis.service.SpringRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/springRedis")
public class SpringRedisContoller {

    @Autowired
    private SpringRedisService springRedisService;

    @GetMapping("/cache")
    public String cache(@RequestParam Integer companyId, @RequestParam Integer orderId){
        return springRedisService.getData(companyId, orderId);
    }

    @GetMapping("/add")
    public String addCache(@RequestParam Integer companyId, @RequestParam Integer orderId){
        springRedisService.addData(companyId, orderId);
        return "OK";
    }

    @GetMapping("/delete")
    public void deleteCache(){
        springRedisService.deleteCache();
    }

    @GetMapping("/delete2")
    public void deleteCache2(){
        springRedisService.deleteCache2();
    }


}
