package com.hcl.demo.service;

import com.hcl.demo.entities.Customer;

/**
 * The Interface ICustomersService.
 */
public interface ICustomersService{

	/**
	 * getCustomer.
	 *
     * @param cusId the cusId
	  * @return the Customer
	 */
	Customer getCustomer(int cusId);
	
	/**
	 * createCustomer.
	 *
     * @param CreateCustomer the CreateCustomer
	  * @return the Customer
	 */
	Customer createCustomer(Customer CreateCustomer);
	

}
