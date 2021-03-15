package com.fduran.MovieApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fduran.MovieApp.Entity.Movie;
import com.fduran.MovieApp.Repository.MovieDao;

@Service
public class MovieServiceImpl implements MovieService{


	@Autowired
	private MovieDao movieDao;
	
	@Override
	@Transactional
	public void save(Movie movie) {
		// TODO Auto-generated method stub
		movieDao.save(movie);
	}

	@Override
	@Transactional
	public List<Movie> findAll() {
			
			return movieDao.findAll();
		
	}

	@Override
	@Transactional
	public Movie findById(Integer id) {
		// TODO Auto-generated method stub
		return movieDao.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		movieDao.deleteById(id);
		
	}

	@Override
	public List<Movie> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return movieDao.findByKeyword(keyword);
	}

	@Override
	public List<Movie> findAllSorting() {
		// TODO Auto-generated method stub
		return 	 movieDao.findAll(Sort.by(Sort.Direction.ASC, "year"));
	}

}
