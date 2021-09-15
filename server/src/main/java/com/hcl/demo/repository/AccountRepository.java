package com.hcl.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.entities.Account;

/**
 * The Interface AccountRepository.
 */
public interface AccountRepository extends JpaRepository<Account, Integer>{

}