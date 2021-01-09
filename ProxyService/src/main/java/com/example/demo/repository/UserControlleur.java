package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.AppUser;

@RestController("/UserControlleur")
public class UserControlleur {

	
	@GetMapping()
	public @ResponseBody Object findByUserName(@PathVariable String userName) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return  principal;
	}
}
