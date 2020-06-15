package com.cognizant.moviecruiser.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@ToString
public class Movie {

	private long id;
	private String title;
	private String boxOffice;
	private boolean active;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;


}
