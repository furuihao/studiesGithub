package com.bjsxt.hibernate.models.practice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	private int id;
	private String name;
	// private Set<Student> students = new HashSet<Student>();
	private Score score;

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

	// @ManyToMany(mappedBy = "courses")
	// public Set<Student> getStudents() {
	// return students;
	// }
	//
	// public void setStudents(Set<Student> students) {
	// this.students = students;
	// }
	//
	@ManyToOne(cascade = { CascadeType.ALL })
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
}
