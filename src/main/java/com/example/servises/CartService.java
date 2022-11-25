package com.example.servises;

import java.util.List;

import com.example.model.CartServiceList;

public interface CartService{


    public List<CartServiceList> fetchCartDetails(String email);

    public String deleteItemFromCart(int cartId , String useremail);
}

