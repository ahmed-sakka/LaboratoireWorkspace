package com.example.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo.entites.User;

 
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private User User;
  private Collection<? extends GrantedAuthority> authorities;
 
  public JwtResponse(String accessToken, User User, Collection<? extends GrantedAuthority> authorities) {
    this.token = accessToken;
    this.User = User;
    this.authorities = authorities;
  }
 
  public String getAccessToken() {
    return token;
  }
 
  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }
 
  public String getTokenType() {
    return type;
  }
 
  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }
 

  
  public User getUser() {
	return User;
}

public void setUser(User User) {
	this.User = User;
}

public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }
}
