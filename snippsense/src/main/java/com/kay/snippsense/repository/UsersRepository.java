package com.kay.snippsense.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.snippsense.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByUsername(String username);
	
	Optional<Users> findByFullname(String fullname);
	
	boolean existsByUsername(String username);

}
