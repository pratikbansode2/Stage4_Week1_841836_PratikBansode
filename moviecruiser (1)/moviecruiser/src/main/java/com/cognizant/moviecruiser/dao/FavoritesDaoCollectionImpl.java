package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;


@Repository
public class FavoritesDaoCollectionImpl implements FavoritesDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(FavoritesDaoCollectionImpl.class);

	private static HashMap<String, Favorites> favoritesUser;
	public  FavoritesDaoCollectionImpl() {
		super();
		if (favoritesUser == null) {
			favoritesUser = new HashMap<String, Favorites>();
		}	
	}
	
	@Override
	public void addFavorites(String userId, long movieId) {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = movieDao.getMovie(movieId);

		LOGGER.info("START ADD  MOVIE FAVORITES");
		if (favoritesUser.containsKey(userId)) {
			List<Movie> movieList = favoritesUser.get(userId).getMovieList();
			movieList.add(movie);
		} else {
			Favorites favorites = new Favorites(new ArrayList<Movie>(), userId);
			favorites.getMovieList().add(movie);
			favoritesUser.put(userId, favorites);
		}
		LOGGER.info(favoritesUser.toString());
		LOGGER.info("END ADD MOVIE FAVORITES");		
	}

	@Override
	public List<Movie> getAllFavoritesItems(String userId) throws FavoritesEmptyException{
		if(favoritesUser.containsKey(userId)) {
			List<Movie> movieList = favoritesUser.get(userId).getMovieList();
			if(movieList.isEmpty()) {
				throw new FavoritesEmptyException();
			}else {
				LOGGER.info("FAVORITES");		
				return movieList;
			}
		}
			return null;
		
	}

	@Override
	public void removeFavorites(String userId, long movieId) throws FavoritesEmptyException{
		// TODO Auto-generated method stub
		int flag=0;
		LOGGER.info("START REMOVE CART ITEM");
		List<Movie> movieList = favoritesUser.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				flag=1;
				movieList.remove(i);
				break;
			}
		}
		if(flag==0) 
			throw (new FavoritesEmptyException());
		LOGGER.info("END REMOVE CART ITEM");
	}

}
