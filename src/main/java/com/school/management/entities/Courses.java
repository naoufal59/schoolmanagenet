package com.school.management.entities;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Courses {

	@Id
	@GeneratedValue
	private Long idCourses;
	private String courseTitle;
	@Lob
	private String courseDescription;

	private String courseVideoID;
	private String courseDriveLink;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date coursePublish;

	@ManyToOne
	@JoinColumn(name = "code_category")
	private Category category;

	@Column(nullable = true, length = 64)
	private String photos;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(String courseTitle, String courseDescription, String courseVideoID, String courseDriveLink,
			Date coursePublish, Category category, String photos) {
		super();
		this.courseTitle = courseTitle;
		this.courseDescription = courseDescription;
		this.courseVideoID = courseVideoID;
		this.courseDriveLink = courseDriveLink;
		this.coursePublish = coursePublish;
		this.category = category;
		this.photos = photos;
	}
	@Transient
    public String getPhotosImagePath() {
        if (photos == null || this.idCourses == null) return null;
         
        return "/courses-photos/" + this.idCourses + "/" + photos;
    }
	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Date getCoursePublish() {
		return coursePublish;
	}

	public void setCoursePublish(Date coursePublish) {
		this.coursePublish = coursePublish;
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
