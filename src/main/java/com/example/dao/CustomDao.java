package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Customer;

public interface CustomDao extends CrudRepository<Customer, Integer>{
	

}
