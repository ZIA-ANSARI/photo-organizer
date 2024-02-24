package com.example.photoorganizer;

import com.example.photoorganizer.utils.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhotoOrganizerApplication implements CommandLineRunner {

	@Autowired
	Storage storage;

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(PhotoOrganizerApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storage.init();
	}

}
