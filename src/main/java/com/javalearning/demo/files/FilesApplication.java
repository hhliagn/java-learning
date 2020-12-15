package com.javalearning.demo.files;

import com.javalearning.demo.files.config.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilesApplication.class, args);
    }
}

