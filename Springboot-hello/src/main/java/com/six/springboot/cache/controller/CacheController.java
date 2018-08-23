package com.six.springboot.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.six.springboot.cache.service.IUserService;
import com.six.springboot.entity.User;
import com.six.springboot.mybatis.mapper.UserMapper;

/**
 * 集成 mybatis xml
 * generator xml
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	private IUserService userService;
	
	
	@RequestMapping("/findByID")
	public User findByID(User u){
		return userService.findByID(u);
	}
	
	
	@RequestMapping("/add")
	public void add(User user){
		userService.add(user);
	}
	
	@RequestMapping("/update")
	public void update(User user){
		userService.update(user);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id){
		userService.delete(id);
	}
	
	
}
