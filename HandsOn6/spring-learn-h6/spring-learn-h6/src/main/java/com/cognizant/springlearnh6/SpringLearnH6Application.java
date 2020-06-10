package com.cognizant.springlearnh6;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class SpringLearnH6Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnH6Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnH6Application.class, args);
		displayCountries();
	}

	public static void displayCountries() {
		LOGGER.info("Start");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
		for(Country country:countries)
		{
			LOGGER.debug("Country : {}", country.toString());
		}
		 LOGGER.info("END");
	}
	
}
