package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {

	public void addFavorites(String userId, long movieId);

	public List<Movie> getAllFavoritesItems(String userId);
	public void removeFavorites(String userId, long movieId);

}
