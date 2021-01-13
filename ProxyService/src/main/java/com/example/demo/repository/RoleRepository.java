package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Role;
import com.example.demo.entites.RoleName;


public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(RoleName roleAdmin);

}
