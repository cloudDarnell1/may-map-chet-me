package com.may.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.may.bean.Student;



@Controller
public class StudentController {
@GetMapping("/student/form")
public String form(Model model) {
	Student student = new Student();
	student.setFullname("Bùi Thảo Vân cute chết mẹ");
	student.setCountry("VN");
	student.setGender(false);
	model.addAttribute("sv", student);
	return "/student/form";
}
@PostMapping("/student/save")
public String save(@ModelAttribute("sv") Student form) {
	return "/student/success";
}
}
