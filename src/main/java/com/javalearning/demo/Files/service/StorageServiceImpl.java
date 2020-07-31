package com.javalearning.demo.Files.service;

import com.javalearning.demo.Files.config.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    private Path rootLocation;

    public StorageServiceImpl(StorageProperties storageProperties){
        this.rootLocation = Paths.get(storageProperties.getRootLocation());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(rootLocation, 1);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAll() {
        try {
            FileSystemUtils.deleteRecursively(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storage(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        //文件验证

        //文件复制 MultipartFile to File
        try (InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, rootLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resource loadAsResource(String fileName) {
        Path file = load(fileName);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("can not read file: {}" + fileName);
            }
        } catch (MalformedURLException e) {
            log.error("can not read file: {}", fileName, e);
            throw new RuntimeException("can not read file: {}" + fileName);
        }
    }

    @Override
    public Path load(String fileName) {
        return rootLocation.resolve(fileName);
    }
}
