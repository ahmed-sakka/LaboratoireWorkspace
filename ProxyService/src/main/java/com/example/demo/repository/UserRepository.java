package com.example.demo.repository;

import com.example.demo.entites.User;

public interface UserRepository extends AbstractRepository<User> {
	
	public User findByUsername(String userName);
	public User findByEmail(String email);
	public User findById(long id);

	public boolean existsByEmail(String email);

	public boolean existsByUsername(String username);

}
