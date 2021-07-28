package thaovan.java6.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home/index")
    public String home(Model model) {
        model.addAttribute("message", "this is home page");
        return "index";
    }

    @GetMapping("/home/about")
    public String about(Model model) {
        model.addAttribute("message", "this is about page");
        return "index";
    }
}
