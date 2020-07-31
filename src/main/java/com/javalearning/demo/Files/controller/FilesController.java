package com.javalearning.demo.Files.controller;

import com.javalearning.demo.Files.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FilesController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/")
    public List<String> loadAll(){
        return storageService.loadAll()
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public void storage(@RequestBody MultipartFile file){
        storageService.storage(file);
    }

    /**
     * Content-Disposition: 就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
     * Disposition: 意向
     */
    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> file(@PathVariable String fileName){
        Resource file = storageService.loadAsResource(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename())
                .body(file);
    }
}
