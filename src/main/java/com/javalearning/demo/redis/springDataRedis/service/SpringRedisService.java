package com.javalearning.demo.redis.springDataRedis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringRedisService {

    @Cacheable(cacheNames = "order_info", key = "'companyId:' + #p0 + '_orderId:' + #p1")
    public String getData(Integer companyId, Integer orderId){
        log.info("request DB...");
        return "abcd";
    }

    @CachePut(cacheNames = "order_info", key = "'companyId:' + #p0 + '_orderId:' + #p1")
    public void addData(Integer companyId, Integer orderId){
        log.info("DB insert record");
    }
}
