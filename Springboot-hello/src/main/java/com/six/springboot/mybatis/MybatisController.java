package com.six.springboot.mybatis;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.springboot.entity.Account;


/**
 * mybatis 注解
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

	@Autowired
	private AccountMapper aountDao;
	
	@RequestMapping("/findAll")
	public List<Account> findAll(){
		return aountDao.findAccountList();
	}
	
	@RequestMapping("/findByID")
	public Account findByID(Integer id){
		return aountDao.findAccount(id);
	}
	
	
	@RequestMapping("/add")
	public void add(String name, Double money){
		aountDao.add(name, money);
	}
	
	@RequestMapping("/update")
	public void update(String name, Double money, Integer id){
		aountDao.update(name, money, id);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id){
		aountDao.delete(id);
	}
	
	/**
	 * 测试事物
	 */
	@Transactional
	@RequestMapping("/tran")
	public void tran(){
		aountDao.add("aaa", 456);
		int i=1/0;
	}
}
