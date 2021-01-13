package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Role;
import com.example.demo.entites.RoleName;
import com.example.demo.entites.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.security.JwtProvider;
import com.example.demo.service.UserService;
import com.example.response.JwtResponse;
import com.example.response.ResponseMessage;



@RestController
@CrossOrigin("*")
public class AuthRestAPIs {
	 

  @Autowired
  AuthenticationManager authenticationManager;
 
  @Autowired
  UserService userService;
  @Autowired
  RoleRepository roleRepository;
  @Autowired
  private Environment env;
  @Autowired
  PasswordEncoder encoder;
 
 
  @Autowired
  JwtProvider jwtProvider;
 
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@RequestBody User loginRequest) {
 
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
 
    SecurityContextHolder.getContext().setAuthentication(authentication);
 
    String jwt = jwtProvider.generateJwtToken(authentication);
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	User user = userService.findByEmail(userDetails.getUsername());
    return ResponseEntity.ok(new JwtResponse(jwt, user, userDetails.getAuthorities()));
  }
  @GetMapping("/hi")
  public ResponseEntity<?> hi() {
 

	   return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
		          HttpStatus.BAD_REQUEST);  }
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser( @RequestBody User signUpRequest) {
    if (userService.existsByUsername(signUpRequest.getUsername())) {
      return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
          HttpStatus.BAD_REQUEST);
    }
 
    if (userService.existsByEmail(signUpRequest.getEmail())) {
      return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
          HttpStatus.BAD_REQUEST);
    }
 
    // Creating user's account
    User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()));
 
    Set<Role> roles = new HashSet<>();
    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);

    roles.add(adminRole);
    /*
      switch (signUpRequest.getRoles()) {
      case 1:
        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);
        System.out.println(adminRole);
            if(adminRole ==null)
            	throw  new RuntimeException("Fail! -> Cause: User Role not find.");
        
 
        break;
      case 2:
        Role pmRole = roleRepository.findByName(RoleName.ROLE_USER);
        if(pmRole==null)
        	throw new RuntimeException("Fail! -> Cause: User Role not find.");
      
        roles.add(pmRole);
 
        break;
      default:
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER);
        if(userRole==null)    
        	
        throw new RuntimeException("Fail! -> Cause: User Role not find.");
        roles.add(userRole);
      }
 */
    user.setRoles(roles);
    userService.save(user);
 
    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
  }
/*
  @GetMapping("/resetPassword/{email}")
  public ResponseEntity<?> resetPassword(
		@PathVariable("email") String  email) {
      User res = userService.findByEmail(email);
      if (res == null) {
    	    return new ResponseEntity<>(new ResponseMessage("Fail -> User not find"),
    	            HttpStatus.BAD_REQUEST);    	      
    	    
      }
      String token = UUID.randomUUID().toString();
      userService.createPasswordResetTokenForUser(res, token);
      
      mailSender.send(constructResetTokenEmail(token, res));
      return new ResponseEntity<>(new ResponseMessage("Success ->email send !"),
	            HttpStatus.ACCEPTED);    	
  }
  @GetMapping("/checkToken/{id}/{token}")
  public ResponseEntity<?> showChangePasswordPage( @PathVariable("id") long id, @PathVariable("token") String token) {
      String result = userService.validatePasswordResetToken(id, token);
      if (result != null) {
    	  return new ResponseEntity<>(new ResponseMessage("Fail ->" + result),
  	            HttpStatus.BAD_REQUEST);
      }
	  return new ResponseEntity<>(new ResponseMessage("Success ->" +"Change password"),
	            HttpStatus.ACCEPTED);  }


  private SimpleMailMessage constructResetTokenEmail( String token, User user) {
		    String url = "localhost:4200" + "/#/changePassword/" + 
		      user.getId() + "/" + token;
		  
		    return constructEmail("Reset Password", " \r\n" + url, user);
		}
		 
		private SimpleMailMessage constructEmail(String subject, String body, 
		  User user) {
		    SimpleMailMessage email = new SimpleMailMessage();
		    email.setSubject(subject);
		    email.setText(body);
		    email.setTo(user.getEmail());
		    return email;
		}
	
		@GetMapping("/changePassword/{id}/{pass}")
		public ResponseEntity<?> changePassword(@PathVariable("id") long id, @PathVariable("pass") String pass) {
			User user = userService.findById(id);
		    userService.changeUserPassword(user, pass);		  
		    return new ResponseEntity<>(new ResponseMessage("Success ->Mot de passe a changé "),
		            HttpStatus.ACCEPTED);   
		}*/
}
