package com.javalearning.demo.files.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("service")
public class StorageProperties {

    private String rootLocation = "upload-dir";

    public String getRootLocation() {
        return rootLocation;
    }

    public void setRootLocation(String rootLocation) {
        this.rootLocation = rootLocation;
    }
}
