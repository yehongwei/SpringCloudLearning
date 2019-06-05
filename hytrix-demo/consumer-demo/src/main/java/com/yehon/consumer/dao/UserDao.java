package com.yehon.consumer.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yehon.consumer.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	@HystrixCommand(fallbackMethod = "queryUserByIdFallback")
	public User queryUserById(Long id){
		long begin = System.currentTimeMillis();
		String url = "http://user-service/user/" + id;
		User user = this.restTemplate.getForObject(url, User.class);
		long end = System.currentTimeMillis();
		// 记录访问用时：
		logger.info("访问用时：{}", end - begin);
		return user;
	}

	public User queryUserByIdFallback(Long id){
		User user = new User();
		user.setId(id);
		user.setName("用户信息查询出现异常！");
		return user;
	}
}