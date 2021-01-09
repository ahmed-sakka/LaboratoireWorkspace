package com.example.demo.serviceImplements;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entites.AppRole;
import com.example.demo.entites.AppUser;
import com.example.demo.repository.AppRoleRepository;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.IAccountService;
@Service
@Transactional
public class AccountUserImp implements IAccountService {
	
	@Autowired
	AppUserRepository userRepository;
	
	@Autowired
	AppRoleRepository roleRepository;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public AppUser saveUser(String userName, String password, String confirmPassword) {
		AppUser user =userRepository.findByUserName(userName);
		if(user != null) throw new RuntimeException("User existe");
		
		if(!password.equals(confirmPassword)) throw new RuntimeException("Confirm password not valid");
		user =new AppUser();
		user.setPassword(passwordEncoder.encode(password));
		user.setUserName(userName);
		user.setActived(true);
		userRepository.save(user);
		addRoleToUser(userName,"User");
		return user;
	}

	@Override
	public AppRole aave(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public AppUser loadUserBuUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		AppUser user = userRepository.findByUserName(userName);
		AppRole role = roleRepository.findByRoleName(roleName);
		user.getRoles().add(role);
		
	}

}
