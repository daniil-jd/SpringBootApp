package ru.kai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.forms.UserForm;
import ru.kai.services.UserService;


@Controller
public class SignUpController {

    @Autowired
    private UserService service;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm userForm) {
        service.signUp(userForm);
        return "redirect:/login";
    }
}
