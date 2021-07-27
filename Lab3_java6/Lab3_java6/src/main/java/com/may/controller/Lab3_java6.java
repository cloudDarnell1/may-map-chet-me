package com.may.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lab3_java6 {
	@RequestMapping("/lab3_java6")
	public String index(Model model) {
		return "/menu";
	}
}
