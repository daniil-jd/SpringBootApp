package ru.kai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kai.models.Bill;
import ru.kai.models.Check;
import ru.kai.security.details.UserDetailsImpl;
import ru.kai.services.CheckService;
import ru.kai.transfer.CheckDTO;
import ru.kai.transfer.UserDTO;

import java.util.List;
import java.util.Optional;


@Controller
public class ProfileController {

    @Autowired
    private CheckService service;

    @GetMapping("/profile")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        UserDTO user = UserDTO.from(details.getUser());

        List<CheckDTO> checks = service.getChecks(user);
        Optional<Bill> bill = Optional.ofNullable(user.getBill());

        model.addAttribute("user", user);
        model.addAttribute("bill", bill.isPresent()? bill.get().getMoney() : "0");
        model.addAttribute("checks", checks);

        return "profile";
    }
}
