package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavoritesService;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

	@Autowired
	FavoritesService favoritesService;
	
	@PostMapping("/{userId}/{movieId}")
	public void addFavorites(@PathVariable String userId, @PathVariable long movieId) {
		favoritesService.addFavorites(userId, movieId);
	}
	
	@GetMapping("/{userId}")
	public List<Movie> getAllFavoritesItems(@PathVariable String userId){
		return favoritesService.getAllFavoritesItems(userId);
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	public void removeFavorites(@PathVariable String userId,@PathVariable long movieId) {
		favoritesService.removeFavorites(userId, movieId);
	}
}
