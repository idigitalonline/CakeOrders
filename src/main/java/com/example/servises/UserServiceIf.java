package com.example.servises;

import java.util.List;

import com.example.model.Cart;
import com.example.model.User;

public interface UserServiceIf {
    public User SaveUserDetails(User user);
    public User fetchUserByemailIdAndPassword(User user);
    public User fetchById(int id);

    public Cart addOrder(int ServiceId , String  useremail);

}

