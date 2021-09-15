package com.hcl.demo.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entities.Account;
import com.hcl.demo.service.IAccountsService;

/**
 * The class AccountsController
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountsController {

	private static final Logger log = LogManager.getLogger(AccountsController.class);

	/** The accountsService. */
	@Autowired
	private IAccountsService accountsService;

	/**
	 * <b>
	 * <p>
	 * Get a single Account Details
	 *
	 * @param accId
	 *            the accId
	 * @return the Account
	 */

	@RequestMapping(value = "/accounts/{accId}", method = RequestMethod.GET, produces = { "application/json" })
	public Account getAccount(@PathVariable(value = "accId", required = true) int accId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsController.getAccount method with AccId: {}", accId);
		Account accountResponse = accountsService.getAccount(accId);
		log.info("Exiting from the AccountsController.getAccount method with AccId: {} in {}ms \n", accId, System.currentTimeMillis() - startTime);
		return accountResponse;
	}

	/**
	 * <b>
	 * <p>
	 * Get all Accounts
	 *
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the List of Account
	 */

	@RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = { "application/json" })
	public List<Account> getallAccounts(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsController.getallAccounts method ");
		List<Account> accountResponse = accountsService.getallAccounts(page, size);
		log.info("Exiting from the AccountsController.getallAccounts method in {}ms \n", System.currentTimeMillis() - startTime);
		return accountResponse;
	}

	/**
	 * <b>
	 * <p>
	 * Account Updation Service
	 *
	 * @param account
	 *            the account
	 * @return the Account
	 */

	@RequestMapping(value = "/accounts", method = RequestMethod.PUT, consumes = { "application/json" }, produces = { "application/json" })
	public Account updateAccount(@RequestBody(required = true) Account account) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsController.updateAccount method ");
		Account accountResponse = accountsService.updateAccount(account);
		log.info("Exiting from the AccountsController.updateAccount method in {}ms \n", System.currentTimeMillis() - startTime);
		return accountResponse;
	}

	/**
	 * <b>
	 * <p>
	 * Account Creation Service
	 *
	 * @param account
	 *            the CreateAccount
	 * @return the Account
	 */

	@RequestMapping(value = "/accounts", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json" })
	public Account createAccount(@RequestBody(required = true) Account account) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsController.createAccount method ");
		Account accountResponse = accountsService.createAccount(account);
		log.info("Exiting from the AccountsController.createAccount method in {}ms \n", System.currentTimeMillis() - startTime);
		return accountResponse;
	}

	/**
	 * <b>
	 * <p>
	 * Account Deletion Service
	 *
	 * @param accId
	 *            the accId
	 * @return the Account
	 */

	@RequestMapping(value = "/accounts", method = RequestMethod.DELETE, produces = { "application/json" })
	public void deleteAccount(@RequestParam(value = "accId", required = true) int accId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsController.deleteAccount method ");
		accountsService.deleteAccount(accId);
		log.info("Exiting from the AccountsController.deleteAccount method in {}ms \n", System.currentTimeMillis() - startTime);
	}

}