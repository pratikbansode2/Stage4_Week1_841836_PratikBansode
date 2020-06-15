package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.cognizant.truyum.controller", "com.cognizant.truyum.dao","com.cognizant.truyum.model",
"com.cognizant.truyum.service"})
public class TruyumApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumApplication.class, args);
	}

}
