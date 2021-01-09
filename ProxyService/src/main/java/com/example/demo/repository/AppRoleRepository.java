package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entites.AppRole;

@RepositoryRestResource(path = "appRole")
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

	public AppRole findByRoleName(String roleName);
}
