package com.javalearning.demo.commonmistakes.httpinvoke.feignandribbontimeout;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.javalearning.demo.commonmistakes.httpinvoke.feignandribbontimeout")
public class AutoConfig {
}
