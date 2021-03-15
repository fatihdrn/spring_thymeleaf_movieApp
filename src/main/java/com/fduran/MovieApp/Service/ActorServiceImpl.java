package com.fduran.MovieApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fduran.MovieApp.Entity.Actor;
import com.fduran.MovieApp.Repository.ActorDao;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorDao actorDao;

	@Override
	public List<Actor> findAll() {

		return actorDao.findAll();
	}

	@Override
	public void save(Actor actor) {
		actorDao.save(actor);

	}

	@Override
	public Actor findById(Integer id) {

		return actorDao.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		actorDao.deleteById(id);

	}

}
