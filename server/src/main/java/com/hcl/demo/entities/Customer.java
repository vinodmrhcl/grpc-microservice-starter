package com.hcl.demo.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

/**
 * The class Customer
 */

@Entity
@Table(name = "Customer")
@OnDelete(action = OnDeleteAction.CASCADE)

@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	/** The cusId . */
	@Column(name = "cusId")
	private Integer cusId;

	/** The cusName . */
	@Column(name = "cusName")
	private String cusName;

	/** The address . */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;

	/** The contactNo . */
	@Column(name = "contactNo")
	private String contactNo;

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