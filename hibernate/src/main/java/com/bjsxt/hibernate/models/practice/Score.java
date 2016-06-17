package com.bjsxt.hibernate.models.practice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Score {
	private int id;
	private String mark;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getMark() {
		return mark;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
