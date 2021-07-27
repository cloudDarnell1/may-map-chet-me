package thaovan.java6.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping(value = "/auth/access", params = "denied")
    public String loginForbidden(Model model) {
        model.addAttribute("messageFail", "You have no permission");
        return this.login(model);
    }
}
