package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesService {

	@Autowired
	FavoritesDao favoritesDao;
	
	public void addFavorites(String userId, long movieId) {
		favoritesDao.addFavorites(userId, movieId);
	}
	public List<Movie> getAllFavoritesItems(String userId){
		return favoritesDao.getAllFavoritesItems(userId);
	}
	
	public void removeFavorites(String userId,long movieId) {
		favoritesDao.removeFavorites(userId, movieId);
	}
}
