package thaovan.java6.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

@Controller
public class HomeController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/admin")
    public String admin(Model model) {

        if (request.getRemoteUser() == null) {
            return "redirect:/auth/login";
        }

        if (!request.isUserInRole("ADMIN")) {
            return "redirect:/auth/access?denied";
        }

        model.addAttribute("message", "Hello Admin");
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model) {

        if (request.getRemoteUser() == null) {
            return "redirect:/auth/login";
        }

        model.addAttribute("message", "Hello Staff");
        return "index";
    }

    @GetMapping("/authenticated")
    public String authenticated(Model model) {

        if (request.getRemoteUser() == null) {
            return "redirect:/auth/login";
        }

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
