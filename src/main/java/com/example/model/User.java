package com.example.model;



import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Userr")

public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Userr_id")
	private int UserrId;
	@Column(name = "Userr_email")
	private String emailId;
	@Column(name = "Userr_name")
	private String name;	
	@Column(name = "Userr_password")
	private String password;
	public int getUserrId() {
		return UserrId;
	}
	public void setUserrId(int userrId) {
		UserrId = userrId;
	}
	public String getEmailId() {
		return emailId;
	}
	public static String setEmailId(String emailId) {
		//this.emailId = emailId;
		return emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userrId, String emailId, String name, String password) {
		super();
		UserrId = userrId;
		this.emailId = emailId;
		this.name = name;
		this.password = password;
	}
	
	
		
	
	
	}
	