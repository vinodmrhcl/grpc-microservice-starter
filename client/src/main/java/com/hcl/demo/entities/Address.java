package com.hcl.demo.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * The class Address
 */

@Getter
@Setter
public class Address {

	/** The addressId . */
	private Integer addressId;

	/** The streetAddress1 . */
	private String streetAddress1;

	/** The streetAddress2 . */
	private String streetAddress2;

	/** The city . */
	private String city;

	/** The zipCode . */
	private String zipCode;

	/** The countryCd . */
	private String countryCd;

	/** The stateCd . */
	private String stateCd;

	/** The createDTM . */
	private Date createDTM;

	/** The createUserId . */
	private String createUserId;

	/** The lastUpdtDTM . */
	private Date lastUpdtDTM;

	/** The lastUpdtUserId . */
	private String lastUpdtUserId;

}