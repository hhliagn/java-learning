package com.javalearning.demo.commonmistakes.redundantcode.reflection.demo;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface BankFieldAPI {
    int order() default -1;
    int length() default -1;
    String type() default "";
}
