package com.ha.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.billing.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByUsername(String username);

}
