package com.bjsxt.hibernate.models;

public class StuIdCard {
	private int id;
	private String num;
	private Student student;

	public int getId() {
		return id;
	}

	public String getNum() {
		return num;
	}

	public Student getStudent() {
		return student;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
