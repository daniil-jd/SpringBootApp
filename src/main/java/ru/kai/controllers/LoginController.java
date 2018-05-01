package ru.kai.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request) {
        //если пользователь авторизован
        if (authentication != null) {
            return "redirect:/profile";
        }
        //не удалось войти
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        //"редирект" на логин
        return "login";
    }
}
