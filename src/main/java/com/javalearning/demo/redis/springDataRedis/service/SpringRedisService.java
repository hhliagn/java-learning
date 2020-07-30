package com.javalearning.demo.redis.springDataRedis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringRedisService {

    /**
     * 查询加入 cache
     */
    @Cacheable(cacheNames = "order_info", key = "'companyId:' + #p0 + '_orderId:' + #p1")
    public String getData(Integer companyId, Integer orderId){
        log.info("request DB...");
        return "abcd";
    }

    /**
     * 新增数据库 - 同时加入 cache
     */
    @CachePut(cacheNames = "order_info", key = "'companyId:' + #p0 + '_orderId:' + #p1")
    public void addData(Integer companyId, Integer orderId){
        log.info("DB insert record");
    }


    /**
     * 删除数据库 - 同时删除 cache
     */
    // 第一种方式
    // bug here
    // allEntries 默认是 false, 如果要删除所有 key，需要设置成true
    @CacheEvict(value = "order_info", allEntries = true)
    public void deleteCache() {
        log.info("DB deleteByPrimaryKey...");
    }

    // 第二种方式: 批量删除多个 cache
    @Caching(evict = {
            @CacheEvict(value = "order_info", allEntries = true)
    })
    public void deleteCache2() {
        log.info("DB deleteByPrimaryKey...");
    }
}
