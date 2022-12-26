package com.springboot.blog.load;



import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.Data;

	@Data
	public class LoginDto {
	    private String usernameOrEmail;
	    private String password;
		public Object getUsernameOrEmail() {
			// TODO Auto-generated method stub
			return null;
		}
		public Object getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
	
	  @PostMapping("/signin")
	    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
	        Authentication authentication = AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

	        SecurityContextHolder.getContext().setAuthentication((org.springframework.security.core.Authentication) authentication);
	        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	  
	  }
	  }