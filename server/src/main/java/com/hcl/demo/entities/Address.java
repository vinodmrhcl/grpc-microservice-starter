package com.hcl.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * The class Address
 */

@Entity
@Table(name = "Address")

@Getter
@Setter

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	/** The addressId . */
	@Column(name = "addressId")
	private Integer addressId;

	/** The streetAddress1 . */
	@Column(name = "streetAddress1")
	private String streetAddress1;

	/** The streetAddress2 . */
	@Column(name = "streetAddress2")
	private String streetAddress2;

	/** The city . */
	@Column(name = "city")
	private String city;

	/** The zipCode . */
	@Column(name = "zipCode")
	private String zipCode;

	/** The countryCd . */
	@Column(name = "countryCd")
	private String countryCd;

	/** The stateCd . */
	@Column(name = "stateCd")
	private String stateCd;

	/** The createDTM . */
	@Column(name = "createDTM")
	private Date createDTM;

	/** The createUserId . */
	@Column(name = "createUserId")
	private String createUserId;

	/** The lastUpdtDTM . */
	@Column(name = "lastUpdtDTM")
	private Date lastUpdtDTM;

	/** The lastUpdtUserId . */
	@Column(name = "lastUpdtUserId")
	private String lastUpdtUserId;

}