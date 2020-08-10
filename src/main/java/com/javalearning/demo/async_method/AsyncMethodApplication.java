package com.javalearning.demo.async_method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class AsyncMethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncMethodApplication.class, args).close();
	}

	//自定义线程池，以taskExecutor命名Spring才会自动扫描
	@Bean
	public Executor taskExecutor(){
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(3);
		taskExecutor.setMaxPoolSize(3);
		taskExecutor.setQueueCapacity(500);
		taskExecutor.setThreadNamePrefix("GithubLookup-");
		//这行不能少，否则会报错
		taskExecutor.initialize();
		return taskExecutor;
	}
}
