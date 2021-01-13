package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entites.Role;
import com.example.demo.entites.RoleName;
import com.example.demo.entites.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient

public class ProxyServiceApplication implements CommandLineRunner {

	 @Autowired
	  UserService userService;
	  @Autowired
	  RoleRepository roleRepository;
	  @Autowired
	  PasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ProxyServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		 
		if(!userService.existsByEmail("etudiant1@gmail.com"))
		{User user = new User("user", "etudiant1@gmail.com", "etudiant1@gmail.com",
			        encoder.encode("admin123"));
			 
			    Set<Role> roles = new HashSet<>();
			    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);

			    roles.add(adminRole);
			    user.setRoles(roles);
			    userService.save(user);
		}
	}

}
