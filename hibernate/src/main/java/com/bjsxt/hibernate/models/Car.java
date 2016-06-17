package com.bjsxt.hibernate.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	private int id;
	private String name;
	private String color;
	private Tyre tyre;

	public String getColor() {
		return color;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Embedded
//	@AttributeOverrides({ @AttributeOverride(column = @Column(name = "tyre_name"), name = "name") })
	public Tyre getTyre() {
		return tyre;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
}
