package com.fduran.MovieApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fduran.MovieApp.Entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer>{

	@Query(value="select distinct e.* from Movie e ,Actor a where e.id=a.movie_id and (e.name like %:keyword% or e.type like %:keyword% or a.name like %:keyword%) " ,nativeQuery=true)
	List<Movie> findByKeyword(@Param("keyword") String keyword);
}
