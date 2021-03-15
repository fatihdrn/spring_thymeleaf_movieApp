package com.fduran.MovieApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fduran.MovieApp.Entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

	@Query(value = "select distinct e.* from Role e where e.name=:keyword", nativeQuery = true)
	Role findRoleByName(@Param("keyword") String keyword);
}
