package com.hao.studies.mybatis.mapper;

import java.util.List;

import com.hao.studies.mybatis.models.Person;
import com.hao.studies.mybatis.models.PersonVo;

public interface PersonMapper {
	public Person findById(int id) throws Exception;

	public Person findByIdResultMap(int id) throws Exception;

	public List<Person> findPersonList(PersonVo personVo) throws Exception;

	// public List<Person> findByName(String name) throws Exception;
	//
	// public void save(Person p) throws Exception;
	//
	// public void delete(Person p) throws Exception;
	//
	// public void update(Person p) throws Exception;
}
