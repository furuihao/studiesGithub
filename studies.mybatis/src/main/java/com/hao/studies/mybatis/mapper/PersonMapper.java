package com.hao.studies.mybatis.mapper;

import com.hao.studies.mybatis.models.Person;

public interface PersonMapper {
	public Person findById(int id) throws Exception;

//	public List<Person> findByName(String name) throws Exception;
//
//	public void save(Person p) throws Exception;
//
//	public void delete(Person p) throws Exception;
//
//	public void update(Person p) throws Exception;
}
