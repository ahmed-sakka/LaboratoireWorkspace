package com.example.demo.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entites.User;


public interface  UserService  extends UserDetailsService  {
	public User findByUsername(String userName);
	public User findByEmail(String email);

	public boolean existsByEmail(String email);

	public boolean existsByUsername(String username);
	  public UserDetails loadUserByUsername(String username) ;
	public void createPasswordResetTokenForUser(User user, String token);
	public User save(User user);
	public String validatePasswordResetToken(long id, String token);
	public void changeUserPassword(User user, String password);
	public User findById(long id);

}
