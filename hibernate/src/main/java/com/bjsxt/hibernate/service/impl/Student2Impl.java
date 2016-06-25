package com.bjsxt.hibernate.service.impl;

import com.bjsxt.hibernate.service.Student;

public class Student2Impl implements Student {

	@Override
	public void say() {
		System.out.println("student 2 say");

	}

	@Override
	public void ready() {
		System.out.println("student 2 ready");

	}

}
