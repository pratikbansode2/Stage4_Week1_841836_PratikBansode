package com.cognizant.springlearnh4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	private String code;
	private String name;
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country() {
		super();
		LOGGER.debug("Inside Country Constructor");
	}
}
