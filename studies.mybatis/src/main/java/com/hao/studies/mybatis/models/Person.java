package com.hao.studies.mybatis.models;

public class Person {
	private Integer id;
	private String name;
	private Integer age;
	private IdCard idCard;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

	public void sayHello() {
		System.out.println("person hello");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", idCard=" + idCard
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
