package com.hao.studies.mybatis.models;

public class OrderCustome extends Order {
	private String username;
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "OrderCustome [username=" + username + ", address=" + address
				+ ", getId()=" + getId() + ", getNumber()=" + getNumber()
				+ ", getCreatetime()=" + getCreatetime() + ", getNote()="
				+ getNote() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
