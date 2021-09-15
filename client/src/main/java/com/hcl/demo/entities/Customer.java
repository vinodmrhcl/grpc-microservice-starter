package com.hcl.demo.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * The class Customer
 */

@Getter
@Setter
public class Customer {

	/** The cusId . */
	private Integer cusId;

	/** The cusName . */
	private String cusName;

	/** The address . */
	private Address address;

	/** The contactNo . */
	private String contactNo;

	/** The createDTM . */
	private Date createDTM;

	/** The createUserId . */
	private String createUserId;

	/** The lastUpdtDTM . */
	private Date lastUpdtDTM;

	/** The lastUpdtUserId . */
	private String lastUpdtUserId;

}