package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entites.PasswordResetToken;
import com.example.demo.entites.User;
import com.example.demo.entites.UserDetailsImpl;
import com.example.demo.repository.PasswordTokenRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordTokenRepository passwordResetTokenRepository;

	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User Not Found with -> username or email : " + username);
		return UserDetailsImpl.build(user);
	}

	@Override
	public User findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {
		PasswordResetToken myToken = new PasswordResetToken(token, user);
		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		localDate.plusDays(2);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		myToken.setExpiryDate(date);
		passwordResetTokenRepository.save(myToken);

	}

	@Override
	public User save(User user) {
		return userRepository.save(user);

	}

	public String validatePasswordResetToken(long id, String token) {
		PasswordResetToken passToken = passwordResetTokenRepository.findByToken(token);
		if ((passToken == null) || (passToken.getUser().getId() != id)) {
			return "invalidToken";
		}

		Calendar cal = Calendar.getInstance();
		/*
		 * if ((passToken.getExpiryDate() .getTime() - cal.getTime() .getTime()) <= 0) {
		 * return "expired"; }
		 */
		User user = passToken.getUser();
		/*
		 * Authentication auth = new UsernamePasswordAuthenticationToken( user, null,
		 * Arrays.asList( new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
		 * SecurityContextHolder.getContext().setAuthentication(auth);
		 */
		return null;
	}

	public void changeUserPassword(User user, String password) {
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		userRepository.save(user);
	}

	public User findById(long id) {
		return userRepository.findById(id);
	}

}
