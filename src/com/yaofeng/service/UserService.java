package com.yaofeng.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yaofeng.model.User;
import com.yaofeng.util.SqlSessionFactoryUtil;



public class UserService {
		//获得SqlSessionFactory对象
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
	
	public void save(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("com.yaofeng.mapper.IUser.insert",user);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
	
	public void remove(Integer user_id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("com.yaofeng.mapper.IUser.delete",user_id);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
	
	public void update(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("com.yaofeng.mapper.IUser.update",user);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
}
