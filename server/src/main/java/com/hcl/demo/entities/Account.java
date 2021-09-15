package com.hcl.demo.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

/**
 * The class Account
 */

@Entity
@Table(name = "Account")
@OnDelete(action = OnDeleteAction.CASCADE)

@Getter
@Setter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	/** The accId . */
	@Column(name = "accId")
	private Integer accId;

	/** The customer . */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cusId")
	private Customer customer;

	/** The accName . */
	@Column(name = "accName")
	private String accName;

	/** The accBalance . */
	@Column(name = "accBalance")
	private String accBalance;

	/** The accFeature . */
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<AccountFeature> accFeature;

	/** The status . */
	@Column(name = "status")
	private boolean status;

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

	public void setAccFeature(Set<AccountFeature> accFeature) {
		this.accFeature = accFeature;
	}

	public Set<AccountFeature> getAccFeature() {
		return accFeature;
	}

}