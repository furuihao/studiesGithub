package com.hao.studies.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hao.studies.mybatis.dao.SessionFactory;
import com.hao.studies.mybatis.mapper.OrderCustomeMapper;
import com.hao.studies.mybatis.models.Order;
import com.hao.studies.mybatis.models.OrderCustome;
import com.hao.studies.mybatis.models.User;

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

	@Test
	public void testQueryOrderUserByIdResultMap() {
		SqlSession session = SessionFactory.getSession();
		OrderCustomeMapper orderCustomeMapper = session
				.getMapper(OrderCustomeMapper.class);
		Order order = orderCustomeMapper.queryOrderUserByIdResultMap(1);
		System.out.println(order);
		session.close();
	}

	@Test
	public void queryOrderUserAndDetailByIdResultMap() {
		SqlSession session = SessionFactory.getSession();
		OrderCustomeMapper orderCustomeMapper = session
				.getMapper(OrderCustomeMapper.class);
		Order order = orderCustomeMapper
				.queryOrderUserAndDetailByIdResultMap(1);
		System.out.println(order);
		session.close();
	}

	@Test
	public void queryUserItemsByIdResultMap() {
		SqlSession session = SessionFactory.getSession();
		OrderCustomeMapper orderCustomeMapper = session
				.getMapper(OrderCustomeMapper.class);
		User user = orderCustomeMapper.queryUserItemsByIdResultMap(1);
		System.out.println(user);
		session.close();
	}

	@Test
	public void queryOrdersLazyUser() {
		SqlSession session = SessionFactory.getSession();
		OrderCustomeMapper orderCustomeMapper = session
				.getMapper(OrderCustomeMapper.class);
		List<Order> orders = orderCustomeMapper.queryOrdersLazyUser();
		for (Order order : orders) {
			System.out.println(order.getUser());
		}

		session.close();
	}

}
