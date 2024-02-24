package com.example.photoorganizer.controller;

import com.example.photoorganizer.utils.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
public class ImageRecieverController {

    @Autowired
    Storage storage;

    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile[] files){
        String result = "File uploaded successfully";
        for(MultipartFile file: files) {
            if(!storage.save(file)){
                return "File not uploaded properly";
            }
        }
        return "File uploaded successfully";
    }

}
