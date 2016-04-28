package com.hao.studies.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hao.studies.mybatis.dao.SessionFactory;
import com.hao.studies.mybatis.mapper.PersonMapper;
import com.hao.studies.mybatis.models.Person;
import com.hao.studies.mybatis.models.PersonCustom;
import com.hao.studies.mybatis.models.PersonVo;

public class PersonMapperTest {

	@Test
	public void testFindById() throws Exception {
		SqlSession session = SessionFactory.getSession();
		PersonMapper personMapper = session.getMapper(PersonMapper.class);
		Person p = personMapper.findById(1);
		System.out.println(p);
	}

	@Test
	public void testFindByIdResultMap() throws Exception {
		SqlSession session = SessionFactory.getSession();
		PersonMapper personMapper = session.getMapper(PersonMapper.class);
		Person p = personMapper.findByIdResultMap(1);
		System.out.println(p);
	}

	@Test
	public void testFindByList() throws Exception {
		SqlSession session = SessionFactory.getSession();
		PersonMapper personMapper = session.getMapper(PersonMapper.class);
		PersonVo personVo = new PersonVo();
		PersonCustom pc = new PersonCustom();
		// pc.setAge(66);
//		 pc.setName("qq");
		personVo.setIds(new ArrayList<Integer>() {
			{
				add(1);
				add(6);
			}
		});
		personVo.setPersonCustom(pc);
		List<Person> p = personMapper.findPersonList(personVo);
		System.out.println(p);
	}
}
