package com.hcl.demo.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entities.Customer;
import com.hcl.demo.service.ICustomersService;

/**
* The class CustomersController
*/
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomersController {

	private static final Logger log = LogManager.getLogger(CustomersController.class);

	/** The customersService. */
	@Autowired
	private ICustomersService customersService;

	/**
	 *<b> 
	 *<p> Get Customer Service
	 *
     * @param cusId the cusId
	 * @return the Customer
	 */
	 
	 
	@RequestMapping(value = "/customers/{cusId}", method=RequestMethod.GET  , produces={"application/json"})
	public Customer getCustomer(@PathVariable(value="cusId", required=true) int cusId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the CustomersController.getCustomer method with CusId: {}", cusId);
		Customer customerResponse = customersService.getCustomer(cusId);
		log.info("Exiting from the CustomersController.getCustomer method with CusId: {} in {}ms \n", cusId, System.currentTimeMillis()-startTime);
		return customerResponse;
	}
	
	/**
	 *<b> 
	 *<p> Customer Creation Service
	 *
     * @param customer the CreateCustomer
	 * @return the Customer
	 */
	 
	 
	@RequestMapping(value = "/customers", method=RequestMethod.POST , consumes={"application/json"} , produces={"application/json"})
	public Customer createCustomer(@RequestBody(required=true) Customer customer) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the CustomersController.createCustomer method ");
		Customer customerResponse = customersService.createCustomer(customer);
		log.info("Exiting from the CustomersController.createCustomer method in {}ms \n", System.currentTimeMillis()-startTime);
		return customerResponse;
	}
	

}