package com.cognizant.moviecruiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.cognizant.moviecruiser.controller", "com.cognizant.moviecruiser.dao","com.cognizant.moviecruiser.model",
"com.cognizant.moviecruiser.service"})
public class MoviecruiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviecruiserApplication.class, args);
	}

}
