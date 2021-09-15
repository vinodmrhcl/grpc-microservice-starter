package com.hcl.demo.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import com.hcl.demo.entities.Account;
import com.hcl.demo.entities.Customer;
import com.hcl.demo.mapper.AccountProtoMapper;
import com.hcl.demo.mapper.CustomerProtoMapper;
import com.hcl.demo.proto.AccountProto;
import com.hcl.demo.proto.AccountServiceGrpc;
import com.hcl.demo.proto.AccountServiceGrpc.AccountServiceBlockingStub;
import com.hcl.demo.proto.CustomerProto;
import com.hcl.demo.proto.CustomerServiceGrpc;
import com.hcl.demo.proto.CustomerServiceGrpc.CustomerServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * The Class GrpcClient.
 */
@Component
public class GrpcClient {

	private static final Logger log = LogManager.getLogger(GrpcClient.class);

	@Autowired
	private AccountProtoMapper accountProtoMapper;

	@Autowired
	private CustomerProtoMapper customerProtoMapper;

	@Value("${core.server.url}")
	private String url;

	private ManagedChannel createChannel() {
		ManagedChannel channel = ManagedChannelBuilder.forTarget(url).usePlaintext().build();
		return channel;
	}

	/**
	 * getAccount.
	 *
	 * @param accId
	 *            the accId
	 * @return the Account
	 */

	public Account getAccount(int accId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the GrpcClient.getAccount method with AccId: {}", accId);
		ManagedChannel channel = createChannel();
		AccountServiceBlockingStub blockingStub = AccountServiceGrpc.newBlockingStub(channel);
		AccountProto accountProto = blockingStub.getAccount(Int32Value.newBuilder().setValue(accId).build());
		channel.shutdown();
		Account account = accountProtoMapper.map(accountProto);
		log.info("Exiting from the GrpcClient.getAccount method with AccId: {} in {}ms", accId, System.currentTimeMillis() - startTime);
		return account;
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

	public List<Account> getallAccounts(Integer page, Integer size) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the GrpcClient.getallAccounts method ");
		ManagedChannel channel = createChannel();
		AccountServiceBlockingStub blockingStub = AccountServiceGrpc.newBlockingStub(channel);
		List<Account> list = new ArrayList<Account>();
		Iterator<AccountProto> listIter = blockingStub.getAllAccounts(Empty.getDefaultInstance());
		listIter.forEachRemaining(accountProto -> {
			Account account = accountProtoMapper.map(accountProto);
			list.add(account);
		});
		channel.shutdown();
		log.info("Exiting from the GrpcClient.getallAccounts method in {}ms", System.currentTimeMillis() - startTime);
		return list;
	}

	/**
	 * updateAccount.
	 *
	 * @param account
	 *            the account
	 * @return the Account
	 */

	public Account updateAccount(Account account) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the GrpcClient.updateAccount method ");
		AccountProto accountProto = accountProtoMapper.map(account);
		ManagedChannel channel = createChannel();
		AccountServiceBlockingStub blockingStub = AccountServiceGrpc.newBlockingStub(channel);
		accountProto = blockingStub.updateAccount(accountProto);
		channel.shutdown();
		account = accountProtoMapper.map(accountProto);
		log.info("Exiting from the GrpcClient.updateAccount method in {}ms", System.currentTimeMillis() - startTime);
		return account;
	}

	/**
	 * createAccount.
	 *
	 * @param CreateAccount
	 *            the CreateAccount
	 * @return the Account
	 */

	public Account createAccount(Account account) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the GrpcClient.createAccount method ");
		AccountProto accountProto = accountProtoMapper.map(account);
		ManagedChannel channel = createChannel();
		AccountServiceBlockingStub blockingStub = AccountServiceGrpc.newBlockingStub(channel);
		accountProto = blockingStub.createAccount(accountProto);
		channel.shutdown();
		account = accountProtoMapper.map(accountProto);
		log.info("Exiting from the GrpcClient.createAccount method in {}ms", System.currentTimeMillis() - startTime);
		return account;
	}

	/**
	 * deleteAccount.
	 *
	 * @param accId
	 *            the accId
	 * @return the Account
	 */

	public void deleteAccount(int accId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the GrpcClient.deleteAccount method ");
		ManagedChannel channel = createChannel();
		AccountServiceBlockingStub blockingStub = AccountServiceGrpc.newBlockingStub(channel);
		blockingStub.deleteAccount(Int32Value.newBuilder().setValue(accId).build());
		channel.shutdown();
		log.info("Exiting from the GrpcClient.deleteAccount method in {}ms", System.currentTimeMillis() - startTime);
	}

	/**
	 * getCustomer.
	 *
	 * @param cusId
	 *            the cusId
	 * @return the Customer
	 */

	public Customer getCustomer(int cusId) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the GrpcClient.getCustomer method with CusId: {}", cusId);
		ManagedChannel channel = createChannel();
		CustomerServiceBlockingStub blockingStub = CustomerServiceGrpc.newBlockingStub(channel);
		CustomerProto customerProto = blockingStub.getCustomer(Int32Value.newBuilder().setValue(cusId).build());
		channel.shutdown();
		Customer customer = customerProtoMapper.map(customerProto);
		log.info("Exiting from the GrpcClient.getCustomer method with CusId: {} in {}ms", cusId, System.currentTimeMillis() - startTime);
		return customer;
	}

	/**
	 * createCustomer.
	 *
	 * @param CreateCustomer
	 *            the CreateCustomer
	 * @return the Customer
	 */

	public Customer createCustomer(Customer customer) {
		long startTime = System.currentTimeMillis();
		log.info("Entering into the GrpcClient.createCustomer method ");
		CustomerProto customerProto = customerProtoMapper.map(customer);
		ManagedChannel channel = createChannel();
		CustomerServiceBlockingStub blockingStub = CustomerServiceGrpc.newBlockingStub(channel);
		customerProto = blockingStub.createCustomer(customerProto);
		channel.shutdown();
		customer = customerProtoMapper.map(customerProto);
		log.info("Exiting from the GrpcClient.createCustomer method in {}ms", System.currentTimeMillis() - startTime);
		return customer;
	}

}