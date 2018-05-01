package ru.kai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kai.forms.CheckForm;
import ru.kai.services.CheckService;
import ru.kai.services.UserService;
import ru.kai.transfer.CheckDTO;
import ru.kai.transfer.UserDTO;

import java.util.List;


@Controller
public class AdminController {

    @Autowired
    private CheckService checkService;
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String getPage(ModelMap model) {
        List<UserDTO> usersFromServer = userService.getAllUsers();
        List<CheckDTO> checks = checkService.getChecks();

        model.addAttribute("usersFromServer", usersFromServer);
        model.addAttribute("allChecks", checks);
        return "admin";
    }

    @PostMapping("/admin")
    public String signUp(CheckForm form) {
        checkService.saveCheck(form);
        return "redirect:/admin";
    }
}
