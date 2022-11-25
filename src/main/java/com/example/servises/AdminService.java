package com.example.servises;

import java.util.List;

import com.example.model.Admin;
import com.example.model.CartServiceList;

public interface AdminService {

    public Admin fetchAdminByEmailId(String email);
    public CartServiceList addBarberService(CartServiceList barberServiceList);
    public CartServiceList updateService(Integer serviceId, CartServiceList barberServiceList);
    public  String deleteService(int serviceId);
    public List<CartServiceList> getallServices();
    public Admin fetchUserByemailIdAndPassword(Admin admin);


}