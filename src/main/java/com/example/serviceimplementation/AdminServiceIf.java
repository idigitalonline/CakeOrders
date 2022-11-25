package com.example.serviceimplementation;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Admin;
import com.example.model.CartServiceList;
import com.example.repository.Adminrepo;
import com.example.repository.CartServiceRepository;
import com.example.servises.AdminService;



@Service
public class AdminServiceIf implements AdminService{
	
	
	@Autowired
	private Adminrepo adminrepo;
	

	
	@Autowired
	private CartServiceRepository cartServiceRepo;
	
	
	
	



	//find by admin details
	
	 public Admin fetchAdminByEmailId(String email) {

		return adminrepo.findByAdminEmail(email).orElseThrow(() -> new ResourceNotFoundException("Admin", "Name", email));
		
	}
	
		
		
	// add barbers serves and price

	public  CartServiceList addBarberService(CartServiceList cartServiceList) {
		CartServiceList bs = cartServiceRepo.save( cartServiceList);
		return bs;
	}
		
	// update barber exerting services and prices
	
	public CartServiceList updateService(Integer serviceId, CartServiceList barberServiceList) {
		 CartServiceList bsl = cartServiceRepo.findById(serviceId).get();
		 bsl.setServiceId(barberServiceList.getServiceId());
		bsl.setServiceName(barberServiceList.getServiceName());
		bsl.setServicePrice(barberServiceList.getServicePrice());

		
		return  cartServiceRepo.saveAndFlush (bsl);
	}
		
	
	//remove barber services
	
	public  String deleteService(int serviceId) {
		cartServiceRepo.deleteById(serviceId);
		return "Deleted";		
	}
	
	// see all barbers services
	
	public List<CartServiceList> getallServices(){
		return cartServiceRepo.findAll();		
	}



	public Admin fetchUserByemailIdAndPassword(Admin admin) {
		String tempEmailId = admin.getAdminEmail();
		String temppass = admin.getAdminPassword();
		Admin adminObj = null;
			if((tempEmailId) != null && temppass != null){				
					adminObj = adminrepo.findByAdminEmailAndAdminPassword(tempEmailId, temppass);	
				}
			
			if(adminObj == null) {
				throw new  ResourceNotFoundException("Admin", "email", adminObj);	
		
		}

		return adminObj;
	}
	
		
	
}


