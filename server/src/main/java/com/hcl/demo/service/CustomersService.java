package com.hcl.demo.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.entities.Customer;
import com.hcl.demo.repository.CustomerRepository;

/**
 * The Class CustomersService.
 */
@Service
@Transactional
public class CustomersService implements ICustomersService {

	private static final Logger log = LogManager.getLogger(CustomersService.class);

	/** The customerRepository. */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * getCustomer.
	 *
	 * @param cusId
	 *            the cusId
	 * @return the Customer
	 */
	@Override
	public Customer getCustomer(int cusId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the CustomersService.getCustomer method with CusId: {}", cusId);
		Customer customerResponse = customerRepository.findById(cusId).orElse(null);
		log.info("Exiting from the CustomersService.getCustomer method with CusId: {} in {}ms", cusId, System.currentTimeMillis() - startTime);
		return customerResponse;

	}

	/**
	 * createCustomer.
	 *
	 * @param customer
	 *            the CreateCustomer
	 * @return the Customer
	 */
	@Override
	public Customer createCustomer(Customer customer) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the CustomersService.createCustomer method ");
		Customer customerResponse = customerRepository.save(customer);
		log.info("Exiting from the CustomersService.createCustomer method in {}ms", System.currentTimeMillis() - startTime);
		return customerResponse;

	}

}