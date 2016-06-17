package com.bjsxt.hibernate.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_group")
public class Group {
	private int id;
	private String name;
	private Set<User> users = new HashSet<User>();

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

	// Cascade管增删改
	// fetch管读取
	@OneToMany(mappedBy = "group", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	// @JoinColumn(name="groupId")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
