package com.hoa.studies.person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hao.studies.mybatis.models.Person;

public class TestPerson {

	@Test
	public void test() throws IOException {
		InputStream resourceAsStream = Resources
				.getResourceAsStream("config/mybatis/SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(resourceAsStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person p = sqlSession.selectOne("person.findPersonByid", 1);
		System.out.println(p.getName());

		List<Person> ps = sqlSession.selectList("person.findPersonLikeName",
				"kk");
		for (Person person : ps) {
			System.out.println(person);

		}

		sqlSession.close();
	}

}
