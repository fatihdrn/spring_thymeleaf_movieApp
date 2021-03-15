package com.fduran.MovieApp.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.fduran.MovieApp.Entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	@Query(value="select * from User e where e.username=:keyword" ,nativeQuery=true)
	User findByUserName(@Param("keyword") String keyword);
}
