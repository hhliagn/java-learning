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

/**
 * @author lhh
 * @date 2020/5/20
 */
@Slf4j
@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE) //最后执行
public class PraticeAspect {

    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controller(){
    }

    @Around("controller()")
    public Object aop(ProceedingJoinPoint pjp) throws Throwable {
        //获取请求URI
        String requestUri = "";
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        requestUri = request.getRequestURI();

        //获取类名方法名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String classAndMethod = methodSignature.toShortString();

        //获取请求参数
        String requestParams = objectMapper.writeValueAsString(pjp.getArgs());


        log.info(String.format("【入参日志】请求URI %s, 调用 %s, 耗时：%s ms",
                requestUri, classAndMethod, requestParams));

        Object returnValue = null;
        Instant begin = Instant.now();
        try {
            returnValue = pjp.proceed();
            log.info(String.format("【成功打点】调用 %s, 耗时：%s ms",
                    classAndMethod, Duration.between(begin, Instant.now()).toMillis()));
        } catch (Throwable ex) {
            log.error(String.format("【失败打点】调用 %s, 耗时：%s ms",
                    classAndMethod, Duration.between(begin, Instant.now()).toMillis()), ex);
            throw ex;
        }

        return returnValue;
    }
}
