package com.school.management.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dao.CategoryRepository;
import com.school.management.dao.CourseRepository;
import com.school.management.entities.Category;
import com.school.management.entities.Courses;

@Service
public class CoursesServices {

	@Autowired
	public CourseRepository courseRepository;

	@Autowired
	public CategoryRepository categoryRepository;

	@Transactional
	public List<Courses> findAllCourses() {
		return courseRepository.findAll();
	}

	@Transactional
	public List<Courses> findAllCourses(Category category) {
		return courseRepository.findByCategory(category);
	}

	@Transactional
	public Courses addCources(Courses c, Long category) {
		Optional<Category> eq = categoryRepository.findById(category);
		c.setCategory(eq.get());

		return courseRepository.save(c);
	}

	@Transactional
	public Courses getCourse(Long idC) {
		return courseRepository.findById(idC).get();
	}
	
	@Transactional
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
}
