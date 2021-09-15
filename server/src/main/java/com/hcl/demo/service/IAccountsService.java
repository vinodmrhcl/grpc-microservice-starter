package com.hcl.demo.service;

import java.util.List;

import com.hcl.demo.entities.Account;

/**
 * The Interface IAccountsService.
 */
public interface IAccountsService{

	/**
	 * getAccount.
	 *
     * @param accId the accId
	  * @return the Account
	 */
	Account getAccount(int accId);
	
	/**
	 * getallAccounts.
	 *
     * @param page the page
     * @param size the size
	  * @return the List of Account
	 */
	List<Account> getallAccounts(Integer page, Integer size);
	
	/**
	 * updateAccount.
	 *
     * @param account the account
	  * @return the Account
	 */
	Account updateAccount(Account account);
	
	/**
	 * createAccount.
	 *
     * @param CreateAccount the CreateAccount
	  * @return the Account
	 */
	Account createAccount(Account CreateAccount);
	
	/**
	 * deleteAccount.
	 *
     * @param accId the accId
	  * @return the Account
	 */
	Account deleteAccount(int accId);
	

}
