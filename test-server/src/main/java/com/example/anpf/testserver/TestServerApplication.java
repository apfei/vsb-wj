package com.example.anpf.testserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestServerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TestServerApplication.class, args);
		SpringApplication app = new SpringApplication(TestServerApplication.class);
		app.setAddCommandLineProperties(false);
		app.run(args);
	}

}