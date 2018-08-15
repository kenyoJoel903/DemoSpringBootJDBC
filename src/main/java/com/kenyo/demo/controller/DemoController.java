package com.kenyo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.demo.model.Customer;
import com.kenyo.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Customer customer){
		customerRepository.create(customer);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> listAll(){
		List<Customer> customers = customerRepository.listAll();
		if(customers == null) {
			customers = new ArrayList<>();
		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

}

