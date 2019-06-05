package com.yehon.consumer.service;

import com.yehon.consumer.dao.UserDao;
import com.yehon.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserDao userDao;

	@Autowired
	private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息

	public List<User> queryUserByIds(List<Long> ids) {
		List<User> users = new ArrayList<>();
		ids.forEach(id -> {
			// 我们测试多次查询，
			users.add(userDao.queryUserById(id));
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