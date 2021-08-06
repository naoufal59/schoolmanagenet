package com.school.management.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Courses {

	@Id
	@GeneratedValue
	private Long idCourses;
	private String courseTitle;
	@Lob
	private String courseDescription;
//	private String courseType;
	private String courseVideoID;
	private String courseDriveLink;
//	private Date coursePublish;
	@ManyToOne
	@JoinColumn(name = "code_category")
	private Category category;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	 

	public Courses(String courseTitle, String courseDescription, String courseVideoID, String courseDriveLink,
			Category category) {
		super();
		this.courseTitle = courseTitle;
		this.courseDescription = courseDescription;
		this.courseVideoID = courseVideoID;
		this.courseDriveLink = courseDriveLink;
		this.category = category;
	}



	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Long getIdCourses() {
		return idCourses;
	}

	public void setIdCourses(Long idCourses) {
		this.idCourses = idCourses;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	 

	public String getCourseVideoID() {
		return courseVideoID;
	}

	public void setCourseVideoID(String courseVideoID) {
		this.courseVideoID = courseVideoID;
	}

	public String getCourseDriveLink() {
		return courseDriveLink;
	}

	public void setCourseDriveLink(String courseDriveLink) {
		this.courseDriveLink = courseDriveLink;
	}

	 
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
