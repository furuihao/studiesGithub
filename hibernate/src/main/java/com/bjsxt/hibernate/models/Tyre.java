package com.bjsxt.hibernate.models;

import javax.persistence.Column;

public class Tyre {
	private String name;
	private String size;

	@Column(name="tyre_name")
	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
