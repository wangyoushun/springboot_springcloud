package com.six.springboot.jdbc;

import java.util.List;

import com.six.springboot.entity.User;

public interface IUserDao {
	int add(User account);

	int update(User account);

	int delete(int id);

	User findAccountById(int id);

	List<User> findAccountList();
}
