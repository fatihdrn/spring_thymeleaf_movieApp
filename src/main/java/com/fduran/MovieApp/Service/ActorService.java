package com.fduran.MovieApp.Service;

import java.util.List;

import com.fduran.MovieApp.Entity.Actor;

public interface ActorService {

	public List<Actor> findAll();
	public void save(Actor actor);
	public Actor findById(Integer id);
	public void deleteById(Integer id);
	
}
