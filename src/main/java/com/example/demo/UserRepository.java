package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDocument, Integer> {

	
	UserDocument findByUsername(String username);

	boolean existsByUsername(String username);

	UserDocument findByOtpvalue(Integer otp);

}
