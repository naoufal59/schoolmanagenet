package com.school.management.controleur;

import java.beans.Transient;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.school.management.entities.Courses;
import com.school.management.helper.FileUploadUtil;
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
	public String save(Courses p, Model model, @RequestParam(name = "code", defaultValue = "-1") Long code,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		p.setPhotos(fileName);

		coursesServices.addCources(p, code);

		String uploadDir = "courses-photos/" + p.getIdCourses();

		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

		return "redirect:/adminCourseForm";
	}
	@RequestMapping(value = "/admintablecourse")
	public String admintablecourse(Model model) {
		model.addAttribute("courses", coursesServices.findAllCourses());
		return "table-courses";
	}
//	@Transient
//	public String getPhotosImagePath() {
//		if (photos == null || id == null)
//			return null;
//
//		return "/courses-photos/" + id + "/" + photos;
//	}
}
