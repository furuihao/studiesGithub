package com.hao.studies.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hao.studies.mybatis.dao.SessionFactory;
import com.hao.studies.mybatis.mapper.OrderCustomeMapper;
import com.hao.studies.mybatis.models.OrderCustome;

public class OrderCustomeMapperTest {

	@Test
	public void test() {
		SqlSession session = SessionFactory.getSession();
		OrderCustomeMapper orderCustomeMapper = session
				.getMapper(OrderCustomeMapper.class);
		OrderCustome orderCustome = orderCustomeMapper.queryOrderUserById(1);
		System.out.println(orderCustome);
		session.close();
	}

}
