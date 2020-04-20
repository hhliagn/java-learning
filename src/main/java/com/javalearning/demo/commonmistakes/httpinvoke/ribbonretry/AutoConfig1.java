package com.javalearning.demo.commonmistakes.httpinvoke.ribbonretry;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.javalearning.demo.commonmistakes.httpinvoke.ribbonretry")
public class AutoConfig1 {
}
