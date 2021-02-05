package com.javalearning.demo.login_demo.controller;

import com.google.common.collect.Lists;
import com.javalearning.demo.login_demo.model.User;
import com.javalearning.demo.login_demo.anno.CurrentUser;
import com.javalearning.demo.login_demo.common.Const;
import com.javalearning.demo.operate_log.resp.OryxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/api/login")
    public OryxResponse login(@RequestParam String userName, @RequestParam String password){

        if (!loginUser(userName, password)){
            throw new RuntimeException();
        }

        User user = new User();
        user.setCompanyId(12);
        user.setRid(1111);
        user.setRname("系统管理员");
        user.setIsSuper(1);
        String token = "d534a6cb-6e09-47f7-b2e4-b556a435b7df";
        user.setToken(token);

        setCookie(token);
        redisTemplate.opsForValue().set(Const.SESSION_USER + token, user, Const.SESSION_USER_TIMEOUT, TimeUnit.SECONDS);
        return OryxResponse.success(user);
    }

    private void setCookie(String token) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        Cookie cookie = new Cookie(Const.COOKIE_KEY, token);
        cookie.setMaxAge(Const.SESSION_USER_TIMEOUT);
        response.addCookie(cookie);
    }

    private boolean loginUser(String userName, String password) {
        return true;
    }

    @CurrentUser
    @PostMapping("/api/user/orders")
    public OryxResponse getOrders(@RequestParam Integer userId){
        List<String> list = Lists.newArrayList("aaa", "bbb", "ccc");
        return OryxResponse.success(list);
    }
}
