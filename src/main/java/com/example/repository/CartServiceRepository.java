package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cart;
import com.example.model.CartServiceList;

@Repository
public interface CartServiceRepository extends JpaRepository<CartServiceList, Integer> {

	static List<Cart> findByUserid(int userrId) {
		// TODO Auto-generated method stub
		return null;
	}	

}
