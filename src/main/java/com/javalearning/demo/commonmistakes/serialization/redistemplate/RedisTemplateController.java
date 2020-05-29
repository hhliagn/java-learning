package com.javalearning.demo.commonmistakes.serialization.redistemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/redistemplate")
public class RedisTemplateController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;

    @PostConstruct
    public void init() throws JsonProcessingException {
        User user = new User("lhh", 24);
        redisTemplate.opsForValue().set("redisTemplate", user);
        stringRedisTemplate.opsForValue().set("stringRedisTemplate", objectMapper.writeValueAsString(user));
    }

    @GetMapping("/wrong")
    public void wrong(){
        log.info("redisTemplate get: {}",redisTemplate.opsForValue().get("stringRedisTemplate"));
        log.info("stringRedisTemplate get: {}",stringRedisTemplate.opsForValue().get("redisTemplate"));
    }

    @GetMapping("/right")
    public void right() throws JsonProcessingException {
        User userFromRedisTemplate = (User) this.redisTemplate.opsForValue().get("redisTemplate");
        log.info("userFromRedisTemplate: {}", userFromRedisTemplate);

        User userFromStringRedisTemplate
                = objectMapper.readValue(stringRedisTemplate.opsForValue().get("stringRedisTemplate"), User.class);
        log.info("userFromStringRedisTemplate: {}", userFromStringRedisTemplate);
    }

    @GetMapping("/right2")
    public void right2() {
        User user = new User("zhuye", 36);
        userRedisTemplate.opsForValue().set(user.getName(), user);
        User userFromRedis = userRedisTemplate.opsForValue().get(user.getName());
        log.info("userRedisTemplate get {} {}", userFromRedis, userFromRedis.getClass());
        log.info("stringRedisTemplate get {}", stringRedisTemplate.opsForValue().get(user.getName()));
    }
}
