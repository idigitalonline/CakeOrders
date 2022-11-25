package com.example.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.DuplicateEntryException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Cart;
import com.example.model.User;
import com.example.repository.CartRepository;
import com.example.repository.UserRepository;
import com.example.servises.UserServiceIf;

@Service
public class UserService implements UserServiceIf {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private CartRepository cartRepo;

	
	
		

	

	// save the user details form the form if not duplicated
	public User SaveUserDetails(User user) throws DuplicateEntryException
	{

		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)){
			User userobj = userrepo.findByEmailId(tempEmailId);		
		
			if(userobj != null) {
				throw new DuplicateEntryException("User","EmailId", userobj);
				}		
		}
		
		User userObj = null;
		userObj = userrepo.save(user);
		return userObj;
	}
	
	
	//get the user detail from the database for authentication
	public User fetchUserByemailIdAndPassword(User user) throws ResourceNotFoundException {
	
		String tempEmailId = user.getEmailId();
		String temppass = user.getPassword();
		User userObj = null;
			if((tempEmailId) != null && temppass != null){	
				
					userObj = userrepo.findByEmailIdAndPassword(tempEmailId, temppass);

				}
			
			if(userObj == null) {
				throw new  ResourceNotFoundException("User", "email", userObj);
		}

		return userObj;
	}
	
	
	//show user by id
	public User fetchById(int id) throws ResourceNotFoundException  {
		User user = userrepo.findById(id).get();
		if (user == null)
		{
			throw new  ResourceNotFoundException("User", "Id", user);	
		}
		else
			return user;
		
	}



public  Cart addOrder(int serviceId , String useremail) {
		User user = userrepo.findByEmailId(useremail);
		Cart cart = new Cart(0 , user.getUserrId(), serviceId);
		return cartRepo.save(cart);
	}
//





}

