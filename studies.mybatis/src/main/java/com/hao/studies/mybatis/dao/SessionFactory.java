package com.hao.studies.mybatis.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	private static SqlSessionFactory sqlSessionFactory;

	public SessionFactory() {
	}

	static {
		try {
			InputStream resourceAsStream = Resources
					.getResourceAsStream("META-INF/mybatis/SqlMapConfig.xml");

			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

}
