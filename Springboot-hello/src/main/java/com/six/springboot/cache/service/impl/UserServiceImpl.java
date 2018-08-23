package com.six.springboot.cache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.six.springboot.cache.service.IUserService;
import com.six.springboot.entity.User;
import com.six.springboot.mybatis.mapper.UserMapper;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/findByID")
	@Cacheable(value = "user", key="#user.id")
	public User findByID(User user) {
		User u = userMapper.selectByPrimaryKey(user.getId());
		System.out.println("findByID @Cacheable key=" + u.getId());
		return u;
	}

	@RequestMapping("/add")
	@CachePut(value = "user", key = "#user.id")
	public User add(User user) {
		userMapper.insertSelective(user);
		System.out.println("add cacheput key=" + user.getId());
		return user;
	}

	@RequestMapping("/update")
	@CachePut(value = "user", key = "#user.id")
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
		System.out.println("update cacheput key=" + user.getId());
	}

	@RequestMapping("/delete")
	@CacheEvict("user")
	public void delete(Integer id) {
		userMapper.deleteByPrimaryKey(id);
		System.out.println("delete @CacheEvict key=" + id);
	}
}
