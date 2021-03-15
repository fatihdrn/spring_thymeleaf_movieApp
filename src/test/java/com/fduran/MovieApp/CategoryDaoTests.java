package com.fduran.MovieApp;


import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.fduran.MovieApp.Entity.Role;

import com.fduran.MovieApp.Repository.RoleDao;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryDaoTests {

	@Autowired
	private RoleDao rolDao;
	
	@Test
	public void testCreateCategory() {
		
		rolDao.save(new Role("ss"));
		
		assertEquals("ss",rolDao.findById(1).get().getName());
		
	}
}
