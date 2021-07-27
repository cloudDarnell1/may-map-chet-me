package thaovan.java6.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("message", "Hello Admin");
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("message", "Hello Staff");
        return "index";
    }

    @GetMapping("/authenticated")
    public String authenticated(Model model) {
        model.addAttribute("message", "Hello authenticated");
        return "index";
    }

    @GetMapping(value = {"/home/index", ""})
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
