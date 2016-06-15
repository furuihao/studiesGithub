package com.hao.studies.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hao.studies.mybatis.dao.PersonDao;
import com.hao.studies.mybatis.dao.SessionFactory;
import com.hao.studies.mybatis.models.Person;

public class PersonDaoImpl implements PersonDao {

	@Override
	public Person findById(int id) throws Exception {
		SqlSession sqlSession = SessionFactory.getSession();
		Person p = sqlSession.selectOne("person.findPersonByid", 1);
		System.out.println(p.getName());

		return p;
	}

	@Override
	public List<Person> findByName(String name) throws Exception {
		SqlSession sqlSession = SessionFactory.getSession();
		List<Person> ps = sqlSession.selectList("person.findPersonLikeName",
				name);
		for (Person person : ps) {
			System.out.println(person);
		}
		return ps;
	}

	@Override
	public void save(Person p) throws Exception {
		SqlSession sqlSession = SessionFactory.getSession();
		sqlSession.insert("person.insert", p);
		System.out.println(p.getId());
		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public void delete(Person p) throws Exception {
		SqlSession sqlSession = SessionFactory.getSession();
		sqlSession.delete("person.deleteById", p.getId());
		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public void update(Person p) throws Exception {
		SqlSession sqlSession = SessionFactory.getSession();
		sqlSession.update("person.updateById", p);
		sqlSession.commit();
		sqlSession.close();

	}

}
