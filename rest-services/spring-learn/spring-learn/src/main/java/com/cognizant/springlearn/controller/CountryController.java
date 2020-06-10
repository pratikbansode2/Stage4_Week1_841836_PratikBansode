package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	@RequestMapping("/country")
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
     	Country country = (Country) context.getBean("country", Country.class);
     	return country;
	}
	
	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
     	ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
     	return countries;
	}
	
	@GetMapping("/country/{code}")
	@ResponseBody
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		Country country = CountryService.getCountry(code);
		return country;
	}
}
