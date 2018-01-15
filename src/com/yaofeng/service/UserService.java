package com.yaofeng.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yaofeng.model.User;
import com.yaofeng.util.SqlSessionFactoryUtil;



public class UserService {
		//���SqlSessionFactory����
		private SqlSessionFactory sqlSessionFactory;
		
		public UserService() {
			sqlSessionFactory = SqlSessionFactoryUtil.openSessionFactory();
		}
	
	
	
	public User selectById(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		User user = null;
		try {
			 user = session.selectOne("com.yaofeng.mapper.IUser.selectById",id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return user;
	}
	
	public List<User> selectAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> userlist= null;
		try {
			userlist = session.selectList("com.yaofeng.mapper.IUser.selectAll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return userlist;
	}
}
