package com.cognizant.moviecruiser.model;

import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@ToString
public class Favorites {

	private List<Movie> movieList;
	private String userId;
	
	public Favorites(List<Movie> movieList, String userId) {
		super();
		this.movieList = movieList;
		this.userId=userId;
	}
}
