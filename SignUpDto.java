package com.springboot.blog.load;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.blog.entity.Role;
import com.springboot.blog.entity.User;
import com.springboot.blog.repository.UserRepository;

public class SignUpDto {

	private Object passwordEncoder;


	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}


@PostMapping("/signup")
public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

    UserRepository userRepositoty;
	UserRepository userRepository;
	// add check for username exists in a DB
    if(userRepository.existsByUsername(signUpDto.getUsername())){
        return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
    }

    // add check for email exists in DB
    if(userRepository.existsByEmail(signUpDto.getEmail())){
        return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
    }

    // create user object
    User user = new User();
    user.setName(signUpDto.getName());
    user.setUsername(signUpDto.getUsername());
    user.setEmail(signUpDto.getEmail());
    user.setPassword(( ( SignUpDto) passwordEncoder).encode(signUpDto.getPassword()));

    SignUpDto roleRepository;
	Role roles = ((Object) ((SignUpDto) roleRepository).findByName("ROLE_ADMIN")).get();
    user.setRoles(Collections.singleton(roles));

    userRepository.save(user);

    return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

}

private Object findByName(String string) {
	// TODO Auto-generated method stub
	return null;
}

private String encode(CharSequence password) {
	// TODO Auto-generated method stub
	return null;
}
}