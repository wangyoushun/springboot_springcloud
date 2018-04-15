package com.six.springboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.six.springboot.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{

}
