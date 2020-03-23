package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Customer;
import com.demo.repository.CustomerRepository;
import com.demo.service.NextSequenceService;

/**
 * @author Abesh
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOG = Logger.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private NextSequenceService nextSequenceService;

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		LOG.info("Adding customer to records");
		customer.setId(nextSequenceService.getNextSequence("customSequences"));
		return customerRepository.save(customer);
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		LOG.info("Getting all customers");
		return customerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable long id) {
		LOG.info("Get customer by id");
		return customerRepository.findById(id);
	}

}
