package com.six.springboot.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.six.springboot.entity.User;
import com.six.springboot.mybatis.mapper.UserMapper;

/**
 * 集成 mybatis xml
 * generator xml
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/mybatis2")
public class MybatisControllerByXml {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/findAll")
	public List<User> findAll(){
		return userMapper.selectAll();
	}
	
	@RequestMapping("/findByID")
	public User findByID(Integer id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	
	@RequestMapping("/add")
	public void add(User user){
		userMapper.insertSelective(user);
	}
	
	@RequestMapping("/update")
	public void update(User user){
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id){
		userMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/findAllPage")
	public List<User> findAllPage(Integer page, Integer pageSize){
		  //将参数传给这个方法就可以实现物理分页了，非常简单。
	    PageHelper.startPage(page, pageSize);
		return userMapper.selectAll();
	}
	
}
