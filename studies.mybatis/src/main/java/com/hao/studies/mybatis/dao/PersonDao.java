package com.hao.studies.mybatis.dao;

import java.util.List;

import com.hao.studies.mybatis.models.Person;

public interface PersonDao {
	public Person findById(int id) throws Exception;

	public List<Person> findByName(String name) throws Exception;

	public void save(Person p) throws Exception;

	public void delete(Person p) throws Exception;

	public void update(Person p) throws Exception;
}
