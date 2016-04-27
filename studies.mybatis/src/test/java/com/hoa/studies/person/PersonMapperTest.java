package com.hoa.studies.person;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hao.studies.mybatis.dao.SessionFactory;
import com.hao.studies.mybatis.mapper.PersonMapper;
import com.hao.studies.mybatis.models.Person;

public class PersonMapperTest {

	@Test
	public void testFindById() throws Exception {
		SqlSession session = SessionFactory.getSession();
		PersonMapper personMapper = session.getMapper(PersonMapper.class);
		Person p = personMapper.findById(1);
		System.out.println(p);
	}

}
