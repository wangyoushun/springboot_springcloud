package com.six.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.six.springboot.entity.User;

@Repository
public class UserDaoImpl implements IUserDao{
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(User account) {
		 return jdbcTemplate.update("insert into user(name, age, address, user_account) values(?, ?, ?, ?)",
	              account.getName(),account.getAge(),account.getAddress(), account.getUserAccount());
	}

	@Override
	public int update(User account) {
		return jdbcTemplate.update("UPDATE  user SET NAME=? ,address WHERE id=?",
                account.getName(),account.getAddress(),account.getId());
	}

	@Override
	public int delete(int id) {
        return jdbcTemplate.update("DELETE from  user where id=?",id);

	}

	@Override
	public User findAccountById(int id) {
		List<User> list = findAccountList();
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> findAccountList() {
		return jdbcTemplate.query("select * from user ", new BeanPropertyRowMapper<User>(User.class));
	}

}
