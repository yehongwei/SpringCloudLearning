package com.yehon.consumer.service;

import com.yehon.consumer.feign.UserFeignClient;
import com.yehon.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;

	public List<User> queryUserByIds(List<Long> ids) {
		List<User> users = new ArrayList<>();
		ids.forEach(id -> {
			// 我们测试多次查询，
			users.add(userFeignClient.queryUserById(id));
			// 每次间隔500毫秒
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		return users;
	}
}