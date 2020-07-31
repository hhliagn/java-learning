package com.javalearning.demo.Files.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void init();
    Stream<Path> loadAll();
    void deleteAll();
    void storage(MultipartFile file);
    Resource loadAsResource(String fileName);
    Path load(String fileName);
}
