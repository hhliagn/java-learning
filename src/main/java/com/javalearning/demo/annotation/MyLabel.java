package com.javalearning.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLabel {

    String value() default "";

    String datePattern() default "yyyy-MM-dd HH:mm:ss";

    String timeZone() default "GMT+8";
}
