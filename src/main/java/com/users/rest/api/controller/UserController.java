package com.users.rest.api.controller;

import java.util.List;

import com.users.rest.api.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.rest.api.model.User;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserServiceImpl userService;
	   
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}
 	@GetMapping
 	public List<User> getAllUsers(){
 		return userService.getAllUsers();
 	}
 	
 	@GetMapping("{id}")
 	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
 		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
 	}
 	
	 @PutMapping("{id}")
 	public ResponseEntity<User> updateUser(@PathVariable("id") long id
 												  , @RequestBody User user){
 		return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
 	}

	 @DeleteMapping("{id}")
 	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
 		userService.deleteUser(id);

 		return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
 	}

}