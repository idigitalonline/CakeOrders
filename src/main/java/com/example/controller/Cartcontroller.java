package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.CartServiceList;
import com.example.servises.CartService;


@RestController
@RequestMapping("/cart")
public class Cartcontroller {
	
	
	@Autowired
	CartService cs;


	@CrossOrigin
	@GetMapping("/showcart/{useremail}")
	//get details of card with card id
	public <cs> List<CartServiceList> getcart(@PathVariable("useremail")String useremail ) {

		return cs.fetchCartDetails(useremail);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{serviceId}/{useremail}")
	public String removeFromCart( @PathVariable("useremail")String useremail, @PathVariable("serviceId") Integer serviceId)
	{

		cs.deleteItemFromCart(serviceId , useremail);
		return "Deleted";
	}
	
	
}
