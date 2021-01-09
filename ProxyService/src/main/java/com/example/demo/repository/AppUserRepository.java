package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entites.AppUser;

@RepositoryRestResource(path = "AppUser")
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

	public AppUser findByUserName(String userName);
}
