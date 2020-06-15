package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Repository
public class MovieDaoCollectionImpl implements MovieDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieDaoCollectionImpl.class);

	public static List<Movie> movieList;
	@Override
	public List<Movie> getMovieListCustomer() {
		ApplicationContext context = new ClassPathXmlApplicationContext("movie.xml");
     	List<Movie> movieListCustomer = context.getBean("movieList", ArrayList.class);
		return movieListCustomer;
	}

	@Override
	public Movie getMovie(long movieId) {
		movieList=getMovieListCustomer();
		LOGGER.debug("MovieList: {} ",movieList);
		return movieList.stream().filter(item->(item.getId()==movieId )).findFirst().orElseThrow(() -> {throw new MovieNotFoundException();});
	}

	@Override
	public void modifyMenuItem(Movie movie) {
		// TODO Auto-generated method stub
		LOGGER.info("MODIFY MOVIE START");
		LOGGER.info(movie.toString());
		LOGGER.info("MODIFY MOVIE END");

	}

}
