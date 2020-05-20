package com.javalearning.demo.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerAspect {

    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerBean() {
    }

    @Around("controllerBean()")
    public Object metrics(ProceedingJoinPoint pjp) throws Throwable {
        //获取请求URL
        String requestURL = "";
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request != null){
                requestURL = request.getRequestURL().toString();
            }
        }

        //获取当前方法的类名和方法名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String classAndMethod = signature.toShortString();
        log.info(String.format("【入参日志】请求URL %s, 调用 %s, 参数 %s",
                requestURL,
                classAndMethod,
                objectMapper.writeValueAsString(pjp.getArgs())));

        Object returnValue = null;
        Instant start = Instant.now();
        try {
            returnValue = pjp.proceed();
            log.info(String.format("【成功打点】调用 %s 成功，耗时：%d ms",
                    classAndMethod,
                    Duration.between(start, Instant.now()).toMillis()));
        } catch (Exception ex) {
            log.error(String.format("【失败打点】调用 %s 失败，耗时：%d ms",
                    classAndMethod,
                    Duration.between(start, Instant.now()).toMillis()),
                    ex);
        }
        return returnValue;
    }
}