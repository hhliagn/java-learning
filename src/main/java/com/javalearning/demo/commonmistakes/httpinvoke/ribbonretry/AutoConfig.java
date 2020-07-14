package com.javalearning.demo.commonmistakes.httpinvoke.ribbonretry;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = "com.javalearning.demo.commonmistakes.httpinvoke.ribbonretry.feign")
public class AutoConfig {
}
