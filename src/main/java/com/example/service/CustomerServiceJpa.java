package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.CustomDao;
import com.example.exception.CustomerNotFoundException;
import com.example.model.Customer;

@Component
public class CustomerServiceJpa {

	@Autowired
	private CustomDao customDao;

	public Customer addCustomer(Customer custo) {
		return customDao.save(custo);
	}

	public Iterable<Customer> getAllCustomers() {
		return customDao.findAll();
	}

	public Customer getCustomer(int id) {
		Optional<Customer> optionalCustomer = customDao.findById(id);
//		return customDao.findById(id).get(); putting exception so manipulating this
		if(!optionalCustomer.isPresent()) {
			throw new CustomerNotFoundException("Custo not available");
		}
		return optionalCustomer.get();
	}

	public void deleteCustomer(int id) {
		customDao.deleteById(id);
	}
	
	public Customer updateCustomer(int id,Customer customer) {
		customer.setId(id);
		return customDao.save(customer);
	}
}
