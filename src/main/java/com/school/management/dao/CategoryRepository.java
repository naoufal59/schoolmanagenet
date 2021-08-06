package com.school.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
