package com.bjsxt.hibernate.models.practice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Score {
	private int id;
	private Double mark;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public Double getMark() {
		return mark;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

}
