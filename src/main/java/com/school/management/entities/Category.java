package com.school.management.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long idcategory;
	
	private String categoryTitle;

	
	public Category(String categoryTitle) {
		super();
		this.categoryTitle = categoryTitle;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(Long idcategory) {
		this.idcategory = idcategory;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	
	
}
