package com.javalearning.demo.operate_log.anno;


import java.lang.annotation.*;


@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateLog {

    OperateType type();
}
