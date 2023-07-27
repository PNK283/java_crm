package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.CustomerDetails;

public interface CustomerServiceInterface {

	public List<CustomerDetails> getAllData();

	public String save(CustomerDetails cd);

	public String update(CustomerDetails id);
	
	public Optional<CustomerDetails> getOneData(Integer id);

	public void delete(Integer id);

}
