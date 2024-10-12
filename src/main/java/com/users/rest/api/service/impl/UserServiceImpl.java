package com.users.rest.api.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.users.rest.api.exception.ResourceNotFoundException;
import com.users.rest.api.model.User;
import com.users.rest.api.repository.UserRepository;
import com.users.rest.api.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("User","ID", id));
	}

	@Override
	public User updateUser(User user, long id) {
		
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id));

		existingUser.setUsername(user.getUsername());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhoneNumber(user.getPhoneNumber());
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {

		userRepository.findById(id).orElseThrow( () ->  new ResourceNotFoundException("User", "Id", id));

		userRepository.deleteById(id);
	}
}
