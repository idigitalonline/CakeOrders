package com.example.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Admin;


@Repository
public interface Adminrepo extends JpaRepository<Admin , Long> {
	
	public Optional <Admin> findByAdminEmail(String email);
	public Admin findByAdminEmailAndAdminPassword(String email, String password);
	
}