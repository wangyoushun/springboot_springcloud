package com.six.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.six.springboot.entity.User;

// 整合jdbc
//等同于同时加上了@Controller和@ResponseBody
@RestController
public class JdbcController {

	@Autowired
	private IUserDao userDao;


	@RequestMapping("/add")
	public String addUser(User user) {
		int add = userDao.add(user);
		return "add effect row " + add;
	}

	@RequestMapping("/update")
	public String updateUser(User user) {
		int add = userDao.add(user);
		return "update effect row " + add;
	}

	@RequestMapping("/delete")
	public String delteUser(@RequestParam(value = "id") Integer id) {
		int add = userDao.delete(id);
		return "update effect row " + add;
	}

	@RequestMapping("/findID")
	public User findIDUser(@RequestParam(value = "id") Integer id) {
		User user = userDao.findAccountById(id);
		return user;
	}

	@RequestMapping("/findAll")
	public List<User> findAll() {
		return userDao.findAccountList();
	}

}
