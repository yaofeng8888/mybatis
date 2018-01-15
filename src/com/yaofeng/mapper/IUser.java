package com.yaofeng.mapper;

import java.util.List;

import com.yaofeng.model.User;

public interface IUser {
	
	User selectById(Integer user_id);
	List<User> selectAll();
	void insert(User user);
	void delete (Integer user_id);
	void update(User user);
}
