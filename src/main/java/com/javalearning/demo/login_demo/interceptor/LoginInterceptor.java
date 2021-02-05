package com.javalearning.demo.login_demo.interceptor;

import com.javalearning.demo.login_demo.anno.CurrentUser;
import com.javalearning.demo.login_demo.common.Const;
import com.javalearning.demo.login_demo.model.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 获取方法注解
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (!method.isAnnotationPresent(CurrentUser.class)) {
            return true;
        }

        // 获取redis内容
        String token = getToken(request);
        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException("用户未登录");
        }

        User user = (User) redisTemplate.opsForValue().get(Const.SESSION_USER + token);
        if (user == null) {
            throw new RuntimeException("用户未登录");
        }

        return true;
    }

    private String getToken(HttpServletRequest request) {

        // 先从param获取
        String token = request.getParameter(Const.TOKEN);
        if (!StringUtils.isEmpty(token)) {
            return token;
        }

        // 再从cookie获取
        Cookie[] cookies = request.getCookies();
        List<String> tokens = Arrays.stream(cookies)
                .filter(n -> n.getName().equals(Const.COOKIE_KEY))
                .limit(1).map(Cookie::getValue).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(tokens)) {
            return null;
        }

        return tokens.get(0);
    }
}