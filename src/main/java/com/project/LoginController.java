package com.project;

import com.project.domain.User;
import com.project.exp.LoginFailExp;
import com.project.repository.UserRepository;
import com.project.service.LoginService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit;
import java.util.Random;





@RestController
public class LoginController {

    private final LoginService loginService;
    private final RestTemplate restTemplate;

    public LoginController(LoginService loginService, RestTemplate restTemplate) {
        this.loginService = loginService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/login")
    public void  login(@RequestParam String login, @RequestParam String password, HttpServletResponse response) throws LoginFailExp {
        String token = loginService.login(login, password);
        response.addHeader("token",token);

    }
}

