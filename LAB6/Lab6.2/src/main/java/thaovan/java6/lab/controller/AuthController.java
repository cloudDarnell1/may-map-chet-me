package thaovan.java6.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public String login(Model model) {
        model.addAttribute("message", "Login Form");
        return "login";
    }

    @GetMapping(value = "/auth/login", params = "failure")
    public String loginFailure(Model model) {
        model.addAttribute("messageFail", "Username or Password is incorrect!");
        return this.login(model);
    }
}
