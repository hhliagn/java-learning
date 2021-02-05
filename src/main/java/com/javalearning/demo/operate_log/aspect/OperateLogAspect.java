package com.javalearning.demo.operate_log.aspect;

import com.javalearning.demo.operate_log.anno.OperateLog;
import com.javalearning.demo.operate_log.anno.OperateType;
import com.javalearning.demo.operate_log.model.AdminLog;
import com.javalearning.demo.operate_log.resp.OryxResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class OperateLogAspect {

    @Pointcut("@annotation(com.javalearning.demo.operate_log.anno.OperateLog)")
    public void aspect() {
    }

    @AfterReturning(pointcut = "aspect()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {

        Class<?> aClass = ret.getClass();
        if (aClass != OryxResponse.class) {
            return;
        }

        OryxResponse res = (OryxResponse) ret;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        OperateLog annotation = method.getAnnotation(OperateLog.class);
        if (annotation == null) {
            return;
        }

        OperateType type = annotation.type();
        String ip = "localhost";
        Integer companyId = 12;
        Integer operateUserId = 1000;
        String operateType = type.name();
        String content = "";
        OryxResponse.LogContent logContent = res.getLogContent();
        if (logContent != null) {
            content = type.getExt().replace("{}", logContent.getContent());
        }

        AdminLog adminLog = AdminLog.builder()
                .companyId(companyId)
                .ip(ip)
                .operateUserId(operateUserId)
                .operateType(operateType)
                .content(content)
                .createdAt(new Date())
                .build();

        System.out.println(adminLog);
    }
}
