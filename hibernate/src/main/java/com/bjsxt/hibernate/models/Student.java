package com.bjsxt.hibernate.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	// private StudentPK pk;//组合主键
	private int id;
	private String name;
	private int age;
	// private StuIdCard stuIdCard;
	private Set<Teacher> teachers = new HashSet<Teacher>();

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@ManyToMany(mappedBy = "students")
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	// public StuIdCard getStuIdCard() {
	// return stuIdCard;
	// }
	//
	// public void setStuIdCard(StuIdCard stuIdCard) {
	// this.stuIdCard = stuIdCard;
	// }

	// public StudentPK getPk() {
	// return pk;
	// }
	//
	// public void setPk(StudentPK pk) {
	// this.pk = pk;
	// }

}
