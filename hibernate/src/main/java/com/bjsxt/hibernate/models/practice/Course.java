package com.bjsxt.hibernate.models.practice;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();
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

	@ManyToMany(mappedBy = "courses")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@OneToOne
	@JoinColumn(name = "score_id")
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
}
