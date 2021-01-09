package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entites.AppRole;
import com.example.demo.service.IAccountService;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient

public class ProxyServiceApplication implements CommandLineRunner {

	@Autowired
	IAccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(ProxyServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		/*AppRole role =new AppRole(null, "User");
		AppRole role2 =new AppRole(null, "Admin");
		accountService.aave(role);
		accountService.aave(role2);
		accountService.saveUser("admin", "123", "123");
		accountService.addRoleToUser("admin", "Admin");*/

		
		
		
	}
	@Bean
	public BCryptPasswordEncoder getBCPE()
	{
		return new BCryptPasswordEncoder();
	}
}


