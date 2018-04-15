package com.six.springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.six.springboot.entity.User;
import com.six.springboot.mybatis.mapper.UserMapper;
import com.six.springboot.redis.RedisDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisDao redisDao;

	@Test
	public void testRedis() {
		redisDao.setKey("aaa", "123");
		String value = redisDao.getValue("aaa");
		System.out.println(value);
	}
	
	@Test
	public void testMybatis() {
		List<User> selectAll = userMapper.selectAll();
		for (User user : selectAll) {
			System.out.println(user);
		}
	}
}
