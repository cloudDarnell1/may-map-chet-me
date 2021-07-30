package thaovan.java6.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import thaovan.java6.lab.service.UserService;

import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

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

    @GetMapping("/oauth2/login/access")
    public String oauthLoginSuccess(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        service.loginFromOauth2(oAuth2AuthenticationToken);
        return "index";
    }
}
