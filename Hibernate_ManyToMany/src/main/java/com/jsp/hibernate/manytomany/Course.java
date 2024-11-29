package com.jsp.hibernate.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private int courseFee;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;
	
	public int getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public int getCourseFee() {
		return courseFee;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
