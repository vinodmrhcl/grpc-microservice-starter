package com.hcl.demo.grpc;

import java.util.List;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import com.hcl.demo.entities.Account;
import com.hcl.demo.mapper.AccountProtoMapper;
import com.hcl.demo.proto.AccountProto;
import com.hcl.demo.proto.AccountServiceGrpc;
import com.hcl.demo.service.AccountsService;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

/**
 * gRPC service providing CRUD methods for entity Account.
 */
@GRpcService
public class AccountGrpcService extends AccountServiceGrpc.AccountServiceImplBase {

	@Autowired
	private AccountsService accountsService;

	@Autowired
	private AccountProtoMapper accountProtoMapper;

	@Override
	public void createAccount(AccountProto request, StreamObserver<AccountProto> responseObserver) {
		Account account = accountProtoMapper.map(request);
		account = accountsService.createAccount(account);
		AccountProto result = accountProtoMapper.map(account);
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

	@Override
	public void updateAccount(AccountProto request, StreamObserver<AccountProto> responseObserver) {
		Account account = accountProtoMapper.map(request);
		account = accountsService.updateAccount(account);
		AccountProto result = accountProtoMapper.map(account);
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

	@Override
	public void getAllAccounts(Empty request, StreamObserver<AccountProto> responseObserver) {
		List<Account> list = accountsService.getallAccounts(null, null);
		list.forEach(account -> {
			AccountProto accountProto = accountProtoMapper.map(account);
			responseObserver.onNext(accountProto);
		});
		responseObserver.onCompleted();
	}

	@Override
	public void getAccount(Int32Value request, StreamObserver<AccountProto> responseObserver) {
		Account account = accountsService.getAccount(request.getValue());
		if (account == null) {
			responseObserver.onError(Status.NOT_FOUND.asException());
			return;
		}
		AccountProto accountProto = accountProtoMapper.map(account);
		responseObserver.onNext(accountProto);
		responseObserver.onCompleted();
	}

	@Override
	public void deleteAccount(Int32Value request, StreamObserver<Empty> responseObserver) {
		accountsService.deleteAccount(request.getValue());
		responseObserver.onNext(Empty.getDefaultInstance());
		responseObserver.onCompleted();
	}
}
