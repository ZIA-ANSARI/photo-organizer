package com.example.photoorganizer.utils;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
//import java.util.logging.Logger;

@Component
public class LocalStorage implements Storage {
    Logger log = (Logger) LoggerFactory.getLogger(LocalStorage.class);
    private final Path root = Paths.get("uploads");



    @Override
    public void init() throws IOException {
        try{
            Files.createDirectory(root);
        }catch (IOException e){
            log.error("Unable to create directory");
//            throw new RuntimeException();
        }
    }


    @Override
    public boolean save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
//            log.error(e.getStackTrace().toString(), e.toString());
            return false;
        }
        return true;
    }
}
