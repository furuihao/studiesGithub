package com.hoa.studies.person;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.hao.studies.mybatis.dao.PersonDao;
import com.hao.studies.mybatis.dao.SessionFactory;
import com.hao.studies.mybatis.dao.impl.PersonDaoImpl;
import com.hao.studies.mybatis.models.Person;

public class TestPerson {
	private PersonDao personDao;

	@Before
	public void init() {
		personDao = new PersonDaoImpl();
	}

	@Test
	public void queryTest() throws Exception {
		// InputStream resourceAsStream = Resources
		// .getResourceAsStream("META-INF/mybatis/SqlMapConfig.xml");
		// SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
		// .build(resourceAsStream);
		// SqlSession sqlSession = sqlSessionFactory.openSession();
		// SqlSession sqlSession = SessionFactory.getSession();
		// Person p = sqlSession.selectOne("person.findPersonByid", 1);
		// System.out.println(p.getName());
		//
		// List<Person> ps = sqlSession.selectList("person.findPersonLikeName",
		// "kk");
		// for (Person person : ps) {
		// System.out.println(person);
		// }
		//
		// sqlSession.close();

		Person p = personDao.findById(1);
		System.out.println(p);
	}

	@Test
	public void insetTest() {
		SqlSession sqlSession = SessionFactory.getSession();
		Person p = new Person("qq", 66);
		sqlSession.insert("person.insert", p);
		System.out.println(p.getId());
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void deleteTest() {
		SqlSession sqlSession = SessionFactory.getSession();
		sqlSession.delete("person.deleteById", 3);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void updateTest() {
		SqlSession sqlSession = SessionFactory.getSession();
		Person p = new Person("qq", 66);
		p.setId(2);
		sqlSession.update("person.updateById", p);
		sqlSession.commit();
		sqlSession.close();
	}
}
