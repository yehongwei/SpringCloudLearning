package com.yehon.user.controller;

import com.yehon.user.pojo.User;
import com.yehon.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User queryById(@PathVariable("id") Long id) throws InterruptedException {
		return this.userService.queryById(id);
	}
}