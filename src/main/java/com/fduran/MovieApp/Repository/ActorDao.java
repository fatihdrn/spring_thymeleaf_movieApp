package com.fduran.MovieApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fduran.MovieApp.Entity.Actor;

public interface ActorDao extends JpaRepository<Actor, Integer> {

}
