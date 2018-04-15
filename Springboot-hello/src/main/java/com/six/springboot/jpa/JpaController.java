package com.six.springboot.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.springboot.entity.Account;

@RestController
@RequestMapping("/jpa")
public class JpaController {

	@Autowired
	private AccountDao accountDao;

	@RequestMapping("/save")
	public Account saveAccount(Account account) {
		return accountDao.saveAndFlush(account);
	}

	@RequestMapping("/update")
	public Account updateAccount(Account account) {
		return accountDao.saveAndFlush(account);
	}

	@RequestMapping("/delete")
	public String deleteAccount(Integer id) {
		accountDao.delete(id);
		return "delete success";
	}

	@RequestMapping("/findByID")
	public Account findByID(Integer id) {
		return accountDao.findOne(id);
	}

	@RequestMapping("/findAll")
	public List<Account> findAll() {
		return accountDao.findAll();
	}

}
