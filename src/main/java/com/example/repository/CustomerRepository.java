package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.CustomerDetails;

public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer> {

}
