package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;

import com.example.service.CustomerService;
import com.example.service.CustomerServiceJpa;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {
/*	@Autowired
	private CustomerService customerService; */

	@Autowired
	private CustomerServiceJpa custoServiceJpa;
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
/*		return customerService.addCustomer(customer); */
		return custoServiceJpa.addCustomer(customer);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomers(){
/*		return customerService.getCustomer(); */
		return (List<Customer>) custoServiceJpa.getAllCustomers();
	}
	
	@GetMapping(value="/{customerId}")
	public Customer getCustomer(@PathVariable("customerId")int id) {
		return custoServiceJpa.getCustomer(id);
	}
	
	@PutMapping(value="/update/{cusNo}",consumes = MediaType.ALL_VALUE)
	public Customer updateCustomer(@PathVariable("cusNo") int id,@RequestBody Customer customer){
		return custoServiceJpa.updateCustomer(id, customer);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteCustomer(@PathVariable("id")int id) {
		custoServiceJpa.deleteCustomer(id);
	}
	
}