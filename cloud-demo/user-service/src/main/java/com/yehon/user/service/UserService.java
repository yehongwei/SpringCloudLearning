package com.yehon.user.service;

import com.yehon.user.mapper.UserMapper;
import com.yehon.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User queryById(Long id) {
		return this.userMapper.selectByPrimaryKey(id);
	}
}