package com.bjsxt.hibernate.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
// @IdClass(TeacherPK.class)
public class Teacher {
	private int id;
	private String name;
	// private TeacherPK pk;
	private String title;
	private Set<Student> students = new HashSet<Student>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "t_teacher_student", joinColumns = { @JoinColumn(name = "t_id") }, inverseJoinColumns = { @JoinColumn(name = "s_id") })
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	// @EmbeddedId
	// public TeacherPK getPk() {
	// return pk;
	// }
	//
	// public void setPk(TeacherPK pk) {
	// this.pk = pk;
	// }
}
