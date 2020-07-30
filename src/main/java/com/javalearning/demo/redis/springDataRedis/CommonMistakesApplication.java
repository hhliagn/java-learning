package com.javalearning.demo.redis.springDataRedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonMistakesApplication.class, args);
    }

    /**
     * 1. 启动类加 @EnableCaching
     *
     * 2. 配置文件
     *    spring.redis.host=127.0.0.1
     *    spring.redis.port=6379
     *    # 使用spring data redis 必须加下面这行，否则报错：Cannot find cache named 'order_info' for Builder
     *    spring.cache.type=redis
     *
     * 3. @Cacheable(cacheNames = "order_info", key = "'companyId:' + #p0 + '_orderId:' + #p1")
     * 4. @CachePut(cacheNames = "order_info", key = "'companyId:' + #p0 + '_orderId:' + #p1")
     * 5. @CacheEvict(value = "order_info", allEntries = true)
     * 6. 如果是对象，可以用 #p0.companyId, #p0.userId
     *
     * 参考：https://segmentfault.com/a/1190000023040110
     */
}

