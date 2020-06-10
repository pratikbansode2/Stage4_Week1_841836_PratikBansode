package com.cognizant.springlearnh3;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class SpringLearnH3Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnH3Application.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnH3Application.class, args);
		displayDate();

	}

	public static void displayDate() {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		 LOGGER.debug(format.toPattern());
		 LOGGER.info("END");
	}
}
