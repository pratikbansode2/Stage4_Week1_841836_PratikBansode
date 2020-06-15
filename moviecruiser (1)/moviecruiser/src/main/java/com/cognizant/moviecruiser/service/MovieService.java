package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {

	@Autowired
	MovieDao movieDao;
	
	public List<Movie> getMovieListCustomer(){
		return movieDao.getMovieListCustomer();
	}
	
	public Movie getMovie(long movieId) {
		return movieDao.getMovie(movieId);
	}
	
	public void modifyMenuItem(Movie movie) {
		movieDao.modifyMenuItem(movie);
	}
}
