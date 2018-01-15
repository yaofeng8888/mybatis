package com.yaofeng.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yaofeng.mapper.IUser;
import com.yaofeng.model.User;
import com.yaofeng.util.SqlSessionFactoryUtil;



public class UserService2 {
		//获得SqlSessionFactory对象
		private SqlSessionFactory sqlSessionFactory;
		
		public UserService2() {
			sqlSessionFactory = SqlSessionFactoryUtil.openSessionFactory();
		}
	
	
	
	public User selectById(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		User user = null;
		try {
			IUser mapper = session.getMapper(IUser.class);
			//mapper 就是IUser的代理对象，或者说是他的实现类
			mapper.selectById(1);

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
			IUser mapper = session.getMapper(IUser.class);
			mapper.selectAll();
			//userlist = session.selectList("com.yaofeng.mapper.IUser.selectAll");
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
			IUser mapper = session.getMapper(IUser.class);
			mapper.insert(user);
			//session.insert("com.yaofeng.mapper.IUser.insert",user);
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
			IUser mapper = session.getMapper(IUser.class);
			mapper.delete(user_id);
			//session.delete("com.yaofeng.mapper.IUser.delete",user_id);
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
			IUser mapper = session.getMapper(IUser.class);
			mapper.update(user);
			//session.update("com.yaofeng.mapper.IUser.update",user);
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
