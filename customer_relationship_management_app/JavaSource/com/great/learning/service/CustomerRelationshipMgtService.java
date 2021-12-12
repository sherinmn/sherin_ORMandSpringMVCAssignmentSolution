package com.great.learning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.great.learning.model.CustomerRelationshipMgt;

@Service
public interface CustomerRelationshipMgtService {

	List<CustomerRelationshipMgt> findAll();

	CustomerRelationshipMgt findById(int customerId);

	void saveCustomer(CustomerRelationshipMgt theCustomer);

	void deleteById(int customerId);

}
