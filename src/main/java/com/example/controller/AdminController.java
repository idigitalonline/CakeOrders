package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Admin;
import com.example.model.CartServiceList;
import com.example.model.User;
import com.example.servises.AdminService;
import com.example.servises.UserServiceIf;




@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserServiceIf userrServiceIf;
	
	
	

	//get admin details by name while login
	@PostMapping("/login")	
	public Admin loginUser(@RequestBody Admin admin) {		
		return adminService.fetchUserByemailIdAndPassword(admin);
	}
	

	
	
	// add barbers services and price
	@PostMapping("/addservice")
	public CartServiceList addService(@RequestBody CartServiceList cartServiceList) {
		
		return adminService.addBarberService(cartServiceList);
	}
	
    // update barber exesting serveses and prices
	
		@PutMapping("/update/{id}")
		public CartServiceList updateServices(@PathVariable("id") Integer serviceId,@RequestBody CartServiceList service) {
		CartServiceList updatedBsl = adminService.updateService(serviceId,service);
		return  updatedBsl;
	}
	
		
		@DeleteMapping("/delete/{id}")
	// remove services
	public  String deleteService(@PathVariable("id") Integer serviceId) {
		adminService.deleteService(serviceId);
		return "Deleted";		
	}
	
		

}
		