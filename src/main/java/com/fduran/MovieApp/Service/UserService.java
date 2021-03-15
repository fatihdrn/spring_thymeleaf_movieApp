package com.fduran.MovieApp.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fduran.MovieApp.Entity.User;
import com.fduran.MovieApp.FormClass.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
