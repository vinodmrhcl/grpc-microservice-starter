package com.hcl.demo.entities;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

/**
 * The class Account
 */

@Getter
@Setter
public class Account {

	/** The accId . */
	private Integer accId;

	/** The customer . */
	private Customer customer;

	/** The accName . */
	private String accName;

	/** The accBalance . */
	private String accBalance;

	/** The accFeature . */
	@JsonManagedReference
	private Set<AccountFeature> accFeature;

	/** The status . */
	private boolean status;

	/** The createDTM . */
	private Date createDTM;

	/** The createUserId . */
	private String createUserId;

	/** The lastUpdtDTM . */
	private Date lastUpdtDTM;

	/** The lastUpdtUserId . */
	private String lastUpdtUserId;

	public void setAccFeature(Set<AccountFeature> accFeature) {
		this.accFeature = accFeature;
	}

	public Set<AccountFeature> getAccFeature() {
		return accFeature;
	}

}