package com.yaofeng.test;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yaofeng.model.User;
import com.yaofeng.service.UserService;

public class DBUtil {

	UserService userService;

	@Before
	public void init() {
		userService = new UserService();

	}

	@Test
	public void selectById() {
		User user = userService.selectById(2);
		System.out.println(user.getUser_name()+"==="+user.getUser_password());
	}
	@Test
	public void selectAll() {
		List<User> list = userService.selectAll();
		System.out.println(list.size());
	}
}
