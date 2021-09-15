package com.hcl.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.entities.Account;
import com.hcl.demo.repository.AccountRepository;

/**
 * The Class AccountsService.
 */
@Service
@Transactional
public class AccountsService implements IAccountsService {

	private static final Logger log = LogManager.getLogger(AccountsService.class);

	/** The accountRepository. */
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * getAccount.
	 *
	 * @param accId
	 *            the accId
	 * @return the Account
	 */
	@Override
	public Account getAccount(int accId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsService.getAccount method with AccId: {}", accId);
		Account accountResponse = accountRepository.findById(accId).orElse(null);
		log.info("Exiting from the AccountsService.getAccount method with AccId: {} in {}ms", accId, System.currentTimeMillis() - startTime);
		return accountResponse;

	}

	/**
	 * getallAccounts.
	 *
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the List of Account
	 */
	@Override
	public List<Account> getallAccounts(Integer page, Integer size) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsService.getallAccounts method ");
		List<Account> list = new ArrayList<>();
		list.addAll((List<Account>) accountRepository.findAll());
		log.info("Exiting from the AccountsService.getallAccounts method in {}ms", System.currentTimeMillis() - startTime);
		return list;

	}

	/**
	 * updateAccount.
	 *
	 * @param account
	 *            the account
	 * @return the Account
	 */
	@Override
	public Account updateAccount(Account account) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsService.updateAccount method ");
		Account accountResponse = accountRepository.save(account);
		log.info("Exiting from the AccountsService.updateAccount method in {}ms", System.currentTimeMillis() - startTime);
		return accountResponse;

	}

	/**
	 * createAccount.
	 *
	 * @param account
	 *            the CreateAccount
	 * @return the Account
	 */
	@Override
	public Account createAccount(Account account) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsService.createAccount method ");
		Account accountResponse = accountRepository.save(account);
		log.info("Exiting from the AccountsService.createAccount method in {}ms", System.currentTimeMillis() - startTime);
		return accountResponse;

	}

	/**
	 * deleteAccount.
	 *
	 * @param accId
	 *            the accId
	 * @return the Account
	 */
	@Override
	public Account deleteAccount(int accId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the AccountsService.deleteAccount");
		accountRepository.deleteById(accId);
		log.info("Exiting from the AccountsService.deleteAccount method in {}ms", System.currentTimeMillis() - startTime);
		return null;

	}

}