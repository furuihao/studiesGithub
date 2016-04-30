package com.hao.studies.mybatis.mapper;

import com.hao.studies.mybatis.models.Order;
import com.hao.studies.mybatis.models.OrderCustome;

public interface OrderCustomeMapper {
	OrderCustome queryOrderUserById(int id);

	Order queryOrderUserByIdResultMap(int id);

	Order queryOrderUserAndDetailByIdResultMap(int id);
}
