package com.yehon.consumer.controller;

import com.yehon.consumer.pojo.User;
import com.yehon.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consume")
public class ConsumerController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> consume(@RequestParam("ids") List<Long> ids) {
		return this.userService.queryUserByIds(ids);
	}
}