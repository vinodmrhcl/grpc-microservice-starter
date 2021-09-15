package com.hcl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.entities.Customer;

/**
 * The Interface CustomerRepository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}