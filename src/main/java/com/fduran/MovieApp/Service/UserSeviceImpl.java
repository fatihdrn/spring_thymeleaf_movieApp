package com.fduran.MovieApp.Service;


import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fduran.MovieApp.Entity.Role;
import com.fduran.MovieApp.Entity.User;
import com.fduran.MovieApp.FormClass.CrmUser;
import com.fduran.MovieApp.Repository.RoleDao;
import com.fduran.MovieApp.Repository.UserDao;

@Service
public class UserSeviceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUsername(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirst_name(crmUser.getFirstName());
		user.setLast_name(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		
		if(crmUser.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
			Role[] rols=new Role[2];
			rols[0]=roleDao.findRoleByName("ROLE_ADMIN");
			rols[1]=roleDao.findRoleByName("ROLE_USER");
			user.setRoles(Arrays.asList(rols));
		}
		else  {
			user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));
		}
		
		//System.out.println(crmUser.getRole()+"ROllllller");
		//user.setRoles(Arrays.asList(roleDao.findRoleByName(crmUser.getRole())));
		
		userDao.save(user);
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
}
