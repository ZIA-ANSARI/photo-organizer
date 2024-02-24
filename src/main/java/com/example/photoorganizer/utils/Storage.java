package com.example.photoorganizer.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface Storage {
    public void init() throws IOException;



    boolean save(MultipartFile file);
}
