package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entites.AppUser;
import com.example.demo.service.IAccountService;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	IAccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("load");
		AppUser user = accountService.loadUserBuUserName(username);
		if(user == null ) throw new UsernameNotFoundException(username + "not found");
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		user.getRoles().forEach(role ->authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		
		return new User(user.getUserName(), user.getPassword(), authorities);
	}

}
