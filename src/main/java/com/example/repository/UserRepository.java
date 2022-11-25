package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;
import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//spring boots created an querry to fetch user by email id
	public User findByEmailId(String email);
	public User findByEmailIdAndPassword(String email, String password);
	
}
