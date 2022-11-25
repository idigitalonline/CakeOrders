package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cart;
import com.example.model.User;
import com.example.servises.UserServiceIf;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceIf userServiceIf;


	//save new user data 
	@CrossOrigin
	@PostMapping("/regester")
	public User registerUser(@RequestBody User user)  {

	 return userServiceIf.SaveUserDetails(user);
	}
	
	//fetch user for login authentication
	@CrossOrigin
	@PostMapping(value ="/login")	
	public User loginUser(@RequestBody User user) {
		return userServiceIf.fetchUserByemailIdAndPassword(user);
	}

   //see user user by id
	@CrossOrigin
	@GetMapping("/{id}")
	public User userbyid(@PathVariable("id") Integer userid)
	{
		return userServiceIf.fetchById(userid);
	}
	
	
	//place a order
	@CrossOrigin
	@PostMapping(value ="/order/{serviceId}/{userId}")
	public Cart Order(@PathVariable("serviceId") Integer serviceId, @PathVariable("userId") String useremail) {

		return userServiceIf.addOrder(serviceId,useremail);

	}


	
	
	
	
	
}

