package com.six.springboot.cache.service;

import com.six.springboot.entity.User;

public interface IUserService {

	User findByID(User  u);

	User add(User user);

	void update(User user);

	void delete(Integer id);
}
