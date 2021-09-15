package com.hcl.demo.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.hcl.demo.entities.Address;
import com.hcl.demo.entities.Customer;
import com.hcl.demo.proto.AddressProto;
import com.hcl.demo.proto.CustomerProto;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, uses = { ProtoMapper.class })
public interface CustomerProtoMapper {

	Customer map(CustomerProto customerProto);

	CustomerProto map(Customer customer);

	Address map(AddressProto addressProto);

	AddressProto map(Address address);

}
