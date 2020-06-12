package com.javalearning.demo.commonmistakes.clientdata;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Inherited
public @interface LoginRequired {
    String sessionKey() default "currentUser";
}
