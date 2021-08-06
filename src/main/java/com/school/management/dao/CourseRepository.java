package com.school.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.entities.Category;
import com.school.management.entities.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {
 
	List<Courses> findByCategory(Category category);
}
