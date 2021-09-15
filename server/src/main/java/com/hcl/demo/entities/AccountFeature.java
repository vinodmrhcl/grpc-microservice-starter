package com.hcl.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

/**
 * The class AccountFeature
 */

@Entity
@Table(name = "AccountFeature")
@OnDelete(action = OnDeleteAction.CASCADE)

@Getter
@Setter

public class AccountFeature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	/** The accountFeatureId . */
	@Column(name = "accountFeatureId")
	private Integer accountFeatureId;

	@ManyToOne
	@JoinColumn(name = "accId")
	private Account account;

	/** The card . */
	@Column(name = "card")
	private String card;

	/** The cardtype . */
	@Column(name = "cardtype")
	private String cardtype;

	/** The cardlimit . */
	@Column(name = "cardlimit")
	private String cardlimit;

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