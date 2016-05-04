package com.hao.studies.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hao.studies.mybatis.dao.SessionFactory;
import com.hao.studies.mybatis.mapper.UserMapper;
import com.hao.studies.mybatis.models.User;

public class UserMapperTest {

	@Test
	public void testGetById() {
		SqlSession session = SessionFactory.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.getById(1);
		System.out.println(user);
		session.close();
	}

	@Test
	public void testUpdate() {
		SqlSession session = SessionFactory.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.getById(1);
		user.setUsername("hao");
		user.setBirthday(new Date());
		userMapper.update(user);
		session.commit();
		session.close();
	}

}
