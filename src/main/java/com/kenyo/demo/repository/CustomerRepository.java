package com.kenyo.demo.repository;

import java.util.List;

import com.kenyo.demo.model.Customer;

public interface CustomerRepository {
	
	void create(Customer customer);
	void update(Customer customer);
	List<Customer> listAll();
	Customer find(long id);
	void delete(long id);

}
