<<<<<<< HEAD
package com.bjsxt.hibernate.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {
	private int id;
	private String name;
	private Group group;

	@ManyToOne(cascade = { CascadeType.ALL })
	public Group getGroup() {
		return group;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
=======
package com.bjsxt.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {
	private int id;
	private String name;
	private Group group;

	@ManyToOne
	public Group getGroup() {
		return group;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
>>>>>>> branch 'master' of https://github.com/furuihao/studiesGithub.git
