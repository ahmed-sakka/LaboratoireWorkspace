package com.example.demo.service;

import com.example.demo.entites.AppRole;
import com.example.demo.entites.AppUser;

public interface IAccountService {

	public AppUser saveUser(String userName, String password, String confirmPassword);

	public AppRole aave(AppRole role);

	public AppUser loadUserBuUserName(String userName);

	public void addRoleToUser(String userName, String roleName);
}
