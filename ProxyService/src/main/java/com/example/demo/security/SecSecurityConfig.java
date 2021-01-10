package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.WebConfigurer;
@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private BCryptPasswordEncoder encoder;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	System.out.println("hello");
	//methode charger user with userName
	auth.userDetailsService(userDetailService)
	.passwordEncoder(encoder);
	
}

@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/login/").permitAll();
		http.authorizeRequests().antMatchers("/AppUser/**","/appRole/**").permitAll();
		http.authorizeRequests().antMatchers("/membre-service/**").permitAll();
		http.authorizeRequests().antMatchers("/outil-service/**").permitAll();
		http.authorizeRequests().antMatchers("/publication-service/**").permitAll();
		http.authorizeRequests().antMatchers("/evenement-service/**").permitAll();
		
		http.authorizeRequests().antMatchers("/UserControlleur/**").permitAll();
		
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAuthentificationFiler(authenticationManager()));
		http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	
}

}
