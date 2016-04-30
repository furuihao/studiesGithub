package com.hao.studies.mybatis.mapper;

import java.util.List;

import com.hao.studies.mybatis.models.Order;
import com.hao.studies.mybatis.models.OrderCustome;
import com.hao.studies.mybatis.models.User;

public interface OrderCustomeMapper {
	OrderCustome queryOrderUserById(int id);

	Order queryOrderUserByIdResultMap(int id);

	Order queryOrderUserAndDetailByIdResultMap(int id);

	User queryUserItemsByIdResultMap(int id);

	List<Order> queryOrdersLazyUser();

}
