package com.example.service;
import com.example.model.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
@Component
public class CustomerService {
	private int customerIdCount = 1;
	private List<Customer> customerList = new CopyOnWriteArrayList<>();
	
	public Customer addCustomer(Customer customer) {
		customer.setId(customerIdCount);
		customerList.add(customer);
		customerIdCount++;
		
		return customer;
	}
	
	public List<Customer> getCustomer() {
		return customerList;
	}
	
	public Customer getCustomer(int customerId) {
		return customerList.stream()
				.filter(c -> c.getId() == customerId)
				.findFirst().get();
	}
	
	public Customer updateCustomer(int id,Customer customer){
		customerList
				.stream()
				.forEach(c -> {
					if(c.getId() == id) {
						c.setCustomerFirstName(customer.getCustomerFirstName());
						c.setCustomerLastName(customer.getCustomerLastName());
						c.setCustomerEmail(customer.getCustomerEmail());
					}
				});
		return customerList.stream().filter(c->c.getId() == id)
							.findFirst()
							.get();
	}
	
	public void deleteCustomer(int id) {
		customerList.stream().forEach(c->{
			if(c.getId() == id) {
				customerList.remove(c);
			}
	});
	}
	
}