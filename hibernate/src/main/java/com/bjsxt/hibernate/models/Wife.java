package com.bjsxt.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Wife {
	private int id;
	private String name;
	private Husband husband;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 外键双向关联,要设置mappedBy,指出在Husband对象的getWife()上管理关系的
	 * 如果没有设置mappedBy,两张表都生成外键约束,造成数据冗余
	 * @return
	 */
	@OneToOne(mappedBy = "wife")
//	@OneToOne
//	@PrimaryKeyJoinColumn
	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}
}
