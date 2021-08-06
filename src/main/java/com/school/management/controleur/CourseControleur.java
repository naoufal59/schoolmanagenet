package com.school.management.controleur;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.management.entities.Courses;
import com.school.management.services.CoursesServices;

@Controller
public class CourseControleur {

	@Autowired
	private CoursesServices coursesServices;

	@RequestMapping(value = "/adminCourseForm")
	public String home(Model model) {
		model.addAttribute("course", new Courses());

		model.addAttribute("categories", coursesServices.getAllCategories());

		return "add-article";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Courses p, Model model, @RequestParam(name = "code", defaultValue = "-1") Long code)
			throws IOException {

		coursesServices.addCources(p, code);

		return "redirect:/adminCourseForm";
	}

}
