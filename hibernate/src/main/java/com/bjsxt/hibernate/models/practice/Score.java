package com.bjsxt.hibernate.models.practice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Score {
	private int id;
	private Double mark;
	private Course course;
	private Student student;

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

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
