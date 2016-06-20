package com.bjsxt.hibernate.models.practice;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Org {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Org parent;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "parent",fetch=FetchType.EAGER)
	private Set<Org> childs = new HashSet<Org>();

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Org getParent() {
		return parent;
	}

	public Set<Org> getChilds() {
		return childs;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(Org parent) {
		this.parent = parent;
	}

	public void setChilds(Set<Org> childs) {
		this.childs = childs;
	}
}
