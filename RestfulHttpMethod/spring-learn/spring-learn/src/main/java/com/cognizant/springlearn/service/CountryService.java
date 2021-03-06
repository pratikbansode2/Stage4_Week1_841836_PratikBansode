package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country;

public class CountryService {

	public static Country getCountry(String code)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
     	ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
     	int flag=0;
     	for(Country country : countries) {
            if(country.getCode().equalsIgnoreCase(code))
            {
            	flag=1;
               return country;
            }
        }
     	
     	return null;
	}
}
