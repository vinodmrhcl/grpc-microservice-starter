package com.hcl.demo.grpc;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.protobuf.Int32Value;
import com.hcl.demo.entities.Customer;
import com.hcl.demo.mapper.CustomerProtoMapper;
import com.hcl.demo.proto.CustomerProto;
import com.hcl.demo.proto.CustomerServiceGrpc;
import com.hcl.demo.service.CustomersService;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

/**
 * gRPC service providing CRUD methods for entity Customer.
 */
@GRpcService
public class CustomerGrpcService extends CustomerServiceGrpc.CustomerServiceImplBase {

	@Autowired
	private CustomersService customersService;

	@Autowired
	private CustomerProtoMapper customerProtoMapper;

	@Override
	public void createCustomer(CustomerProto request, StreamObserver<CustomerProto> responseObserver) {
		Customer customer = customerProtoMapper.map(request);
		customer = customersService.createCustomer(customer);
		CustomerProto result = customerProtoMapper.map(customer);
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

	@Override
	public void getCustomer(Int32Value request, StreamObserver<CustomerProto> responseObserver) {
		Customer customer = customersService.getCustomer(request.getValue());
		if (customer == null) {
			responseObserver.onError(Status.NOT_FOUND.asException());
			return;
		}
		CustomerProto customerToCustomerProto = customerProtoMapper.map(customer);
		responseObserver.onNext(customerToCustomerProto);
		responseObserver.onCompleted();
	}

}
