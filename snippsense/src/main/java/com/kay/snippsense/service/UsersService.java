package com.kay.snippsense.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kay.snippsense.dto.UsersDto;
import com.kay.snippsense.entity.Users;
import com.kay.snippsense.repository.UsersRepository;

@Service
public class UsersService {
	 private final UsersRepository usersRepository;
	    private final BCryptPasswordEncoder passwordEncoder;

	    public UsersService(UsersRepository usersRepository) {
	        this.usersRepository = usersRepository;
	        this.passwordEncoder = new BCryptPasswordEncoder();
	    }
	    
	    public void validateUniqueUsername(String username, Long currentUserId) {
	        Optional<Users> existingUser = usersRepository.findByUsername(username);
	        if (existingUser.isPresent() && !existingUser.get().getUserId().equals(currentUserId)) {
	            throw new RuntimeException("Email already in use");
	        }
	    }


	    public Users registerUser(Users user) {
	        if (usersRepository.existsByUsername(user.getUsername())) {
	            throw new RuntimeException("Username is already taken");
	        }

	        String hashedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(hashedPassword);

	        return usersRepository.save(user);
	    }
	    
	    public Users updateUser(Users user) {
	        return usersRepository.save(user);
	    }

	    public Optional<Users> findByUsername(String username) {
	        return usersRepository.findByUsername(username);
	    }

	    public Optional<Users> findById(Long userId) {
	        return usersRepository.findById(userId);
	    }

	 
	    public UsersDto toDto(Users user) {
	        UsersDto dto = new UsersDto();
	        dto.setUserId(user.getUserId());
	        dto.setUsername(user.getUsername());
	        dto.setFullname(user.getFullname());
	        return dto;
	    }


	    public Users toEntity(UsersDto dto) {
	        Users user = new Users();
	        user.setUserId(dto.getUserId());
	        user.setUsername(dto.getUsername());
	        user.setFullname(dto.getFullname());
	        user.setPassword(dto.getPassword());
	        return user;
	    }
	    
	    public boolean resetPassword(String username, String newPassword) {
	        Optional<Users> optionalUser = usersRepository.findByUsername(username);
	        if (optionalUser.isEmpty()) {
	            return false;
	        }

	        Users user = optionalUser.get();
	        String hashedPassword = passwordEncoder.encode(newPassword);
	        user.setPassword(hashedPassword);
	        usersRepository.save(user);
	        return true;
	    }
}
