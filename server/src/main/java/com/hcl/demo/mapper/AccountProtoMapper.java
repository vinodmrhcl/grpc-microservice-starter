package com.hcl.demo.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.demo.entities.Account;
import com.hcl.demo.entities.AccountFeature;
import com.hcl.demo.proto.AccountFeatureProto;
import com.hcl.demo.proto.AccountProto;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, uses = { ProtoMapper.class })
public interface AccountProtoMapper {

	@Mapping(source = "accFeatureList", target = "accFeature")
	Account map(AccountProto accountProto);

	@AfterMapping
	default void afterMapping(@MappingTarget Account account) {
		account.getAccFeature().forEach(accFeature -> accFeature.setAccount(account));
	}

	@Mapping(source = "accFeature", target = "accFeatureList")
	AccountProto map(Account account);

	AccountFeature map(AccountFeatureProto accountFeatureProto);

	AccountFeatureProto map(AccountFeature accountFeature);

}