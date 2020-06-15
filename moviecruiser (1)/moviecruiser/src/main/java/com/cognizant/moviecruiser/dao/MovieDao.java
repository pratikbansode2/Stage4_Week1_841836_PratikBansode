package com.cognizant.moviecruiser.dao;

import java.util.List;


import com.cognizant.moviecruiser.model.Movie;

public interface MovieDao {
	public List<Movie> getMovieListCustomer();

	public Movie getMovie(long movieId);

	public void modifyMenuItem(Movie movie);
}
