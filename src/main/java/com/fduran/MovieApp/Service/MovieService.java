package com.fduran.MovieApp.Service;

import java.util.List;

import com.fduran.MovieApp.Entity.Movie;

public interface MovieService {

	public void save(Movie movie);
	public List<Movie> findAll();
	public List<Movie> findAllSorting();
	public Movie findById(Integer id);
	public void deleteById(Integer id);
	public List<Movie> findByKeyword(String keyword);
}
