package com.great.learning.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.great.learning.model.CustomerRelationshipMgt;
import com.great.learning.service.CustomerRelationshipMgtService;

@Repository
public class CustomerRelationshipMgtServiceImpl implements CustomerRelationshipMgtService {

	SessionFactory sessionFactory;
	Session session;

	@Autowired
	CustomerRelationshipMgtServiceImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();

		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	public List<CustomerRelationshipMgt> findAll() {
		List<CustomerRelationshipMgt> customers = session.createQuery("from CustomerRelationshipMgt").list();
		return customers;
	}

	public CustomerRelationshipMgt findById(int customerId) {
		CustomerRelationshipMgt customer = session.get(CustomerRelationshipMgt.class, customerId);
		return customer;
	}

	@Transactional
	public void saveCustomer(CustomerRelationshipMgt theCustomer) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(theCustomer);
		transaction.commit();
	}

	@Transactional
	public void deleteById(int customerId) {
		Transaction transaction = session.beginTransaction();
		CustomerRelationshipMgt customer = session.get(CustomerRelationshipMgt.class, customerId);
		session.delete(customer);
		transaction.commit();

	}

	public void print(List<CustomerRelationshipMgt> customers) {
		for (CustomerRelationshipMgt customer : customers) {
			System.out.println(customer);
		}
	}

}
