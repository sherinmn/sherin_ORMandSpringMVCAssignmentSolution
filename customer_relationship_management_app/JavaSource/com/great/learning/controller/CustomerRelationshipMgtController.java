package com.great.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.great.learning.model.CustomerRelationshipMgt;
import com.great.learning.service.CustomerRelationshipMgtService;

@Controller
@RequestMapping("/customers")
public class CustomerRelationshipMgtController {

	@Autowired
	private CustomerRelationshipMgtService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<CustomerRelationshipMgt> customers = customerService.findAll();

		theModel.addAttribute("CustomerRelationshipMgt", customers);

		return "list-customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		CustomerRelationshipMgt customer = new CustomerRelationshipMgt();
		theModel.addAttribute("CustomerRelationshipMgt", customer);
		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("CustomerId") int id, Model theModel) {
		CustomerRelationshipMgt customer = customerService.findById(id);
		theModel.addAttribute("CustomerRelationshipMgt", customer);
		return "customer-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		System.out.println("Trying to save with Id: " + id);

		CustomerRelationshipMgt customer;
		if (id != 0) {
			customer = customerService.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		} else {
			customer = new CustomerRelationshipMgt(firstName, lastName, email);
		}

		customerService.saveCustomer(customer);

		return "redirect:/customers/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("CustomerId") int id) {
		customerService.deleteById(id);
		return "redirect:/customers/list";
	}

}
