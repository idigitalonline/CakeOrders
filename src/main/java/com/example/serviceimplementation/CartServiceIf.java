package com.example.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CartServiceList;
import com.example.model.Cart;
import com.example.model.User;
import com.example.repository.CartServiceRepository;
import com.example.repository.CartRepository;
import com.example.repository.UserRepository;
import com.example.servises.CartService;

@Service
public class CartServiceIf implements CartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private CartServiceRepository serviceRepo;

	@Autowired
	private UserRepository userRepo;


	//get details of card with card id
	public List<CartServiceList> fetchCartDetails(String email) {
		User user = userRepo.findByEmailId(email);

		List<Cart> cartList = cartRepo.findByUserid(user.getUserrId());

		List<Integer> ls = cartList.stream().map(Cart::getBslid).collect(Collectors.toList());

		return serviceRepo.findAllById(ls);
	}

	@Override
	public String deleteItemFromCart(int serviceId , String useremail) {

		User user = userRepo.findByEmailId(useremail);

		int temp = user.getUserrId();
       Cart cart = cartRepo.findByBslidAndUserid(serviceId, temp);

	   cartRepo.deleteById(cart.getCartId());

		return "deleted";
	}

}
