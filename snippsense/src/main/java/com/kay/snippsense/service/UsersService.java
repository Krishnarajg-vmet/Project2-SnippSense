package com.kay.snippsense.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kay.snippsense.entity.Users;
import com.kay.snippsense.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class UsersService {
	
	private UsersRepository userRepository;
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsersService(UsersRepository userRepository, BCryptPasswordEncoder passwordEncoder){
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public Users registerUser(Users user) {
		if(userRepository.existsByUsername(user.getUsername())) {
			throw new RuntimeException("Username already exists");
		}
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
	
	@Transactional
	public Users updateUser(Users user) {
		return userRepository.save(user);
	}
	
	public Optional<Users> findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public boolean resetPassword(String username, String newPassword) {
		if(userRepository.existsByUsername(username)) {
			Optional<Users> user = userRepository.findByUsername(username);
			Users currentUser = user.get();
			currentUser.setPassword(passwordEncoder.encode(newPassword));
			userRepository.save(currentUser);
			
		return true;
		}
		return false;
	}

}
