package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
@RequestMapping("/countries")
@Valid
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
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
	
	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code){
		Country country = CountryService.getCountry(code);
		return country;
	}
	
	@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("Start");
		ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		
		Set<ConstraintViolation<Country>> violations=validator.validate(country);
		List<String> errors=new ArrayList<String>();
		
		for(ConstraintViolation<Country>violation:violations){
			errors.add(violation.getMessage());
		}
		
		if(violations.size()>0){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.toString());
		}
		return country;
	}
}
