package com.hcl.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.client.GrpcClient;
import com.hcl.demo.entities.Customer;

/**
 * The Class CustomersService.
 */
@Service
public class CustomersService implements ICustomersService {

	private static final Logger log = LogManager.getLogger(CustomersService.class);

	@Autowired
	private GrpcClient grpcClient;

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
		Customer customerResponse = grpcClient.getCustomer(cusId);
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
		Customer customerResponse = grpcClient.createCustomer(customer);
		log.info("Exiting from the CustomersService.createCustomer method in {}ms", System.currentTimeMillis() - startTime);
		return customerResponse;

	}

}