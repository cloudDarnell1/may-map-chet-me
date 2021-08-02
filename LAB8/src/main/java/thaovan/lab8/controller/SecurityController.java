package thaovan.lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/security/login/form")
    public String  loginForm(Model model) {
        model.addAttribute("message", "Login please!");
        return "security/login";
    }

    @GetMapping("/security/login/success")
    public String loginSuccess(Model model) {
        model.addAttribute("message", "Login Successfully");
        return "security/login";
    }



}
