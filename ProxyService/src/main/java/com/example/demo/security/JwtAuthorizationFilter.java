package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin",
				"*");
				response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With,Content-Type, Access-Control-Request-Method, Access-Control-RequestHeaders,authorization");
				response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials, authorization");
				if(request.getMethod().equals("OPTIONS")){
				response.setStatus(HttpServletResponse.SC_OK);
				}
				else {
					
				
		
		String jwtToken = request.getHeader("Authorization");
		System.out.println("token = " + jwtToken);
		if(jwtToken == null || ! jwtToken.startsWith("prefix "))
			 {filterChain.doFilter(request, response );
			return ;
			 }
		JWTVerifier verifier=	JWT.require(Algorithm.HMAC256("abderrahman@gmail.com")).build();
			String jwt =jwtToken.substring("prefix ".length());
			System.out.println("jwt = " + jwt);
			DecodedJWT decodejwt=verifier.verify(jwt);
			String userName = decodejwt.getSubject();
			System.out.println("userName= " +userName);
			List<String> roles = decodejwt.getClaims().get("roles").asList(String.class);
			Collection<GrantedAuthority>authority = new ArrayList<>();
			roles.forEach(role -> {
				System.out.println("role = "+ role);
			authority.add(new SimpleGrantedAuthority(role));});
			UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(userName,null, authority);
			SecurityContextHolder.getContext().setAuthentication(user);
			filterChain.doFilter(request, response);
	}
	}

}
