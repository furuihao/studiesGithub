package com.bjsxt.hibernate.service.impl;

import com.bjsxt.hibernate.service.Student;

public class StudentImpl implements Student {

	@Override
	public void say() {
		System.out.println("student 1 say");

	}

	@Override
	public void ready() {
		System.out.println("student 1 ready");

	}

}
