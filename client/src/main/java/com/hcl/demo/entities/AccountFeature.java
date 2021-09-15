package com.hcl.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

/**
 * The class AccountFeature
 */

@Getter
@Setter
public class AccountFeature {

	/** The accountFeatureId . */
	private Integer accountFeatureId;

	@JsonBackReference
	private Account account;

	/** The card . */
	private String card;

	/** The cardtype . */
	private String cardtype;

	/** The cardlimit . */
	private String cardlimit;

	/** The createDTM . */
	private Date createDTM;

	/** The createUserId . */
	private String createUserId;

	/** The lastUpdtDTM . */
	private Date lastUpdtDTM;

	/** The lastUpdtUserId . */
	private String lastUpdtUserId;
	
	}