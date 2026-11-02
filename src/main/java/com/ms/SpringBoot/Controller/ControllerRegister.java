package com.ms.SpringBoot.Controller;


import com.ms.SpringBoot.Model.User;
import com.ms.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class ControllerRegister {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value = "/adduser")
    public String registerUserAction(@Valid User user, BindingResult result, Model model) {
        String returnPage = null;

        User userExists = userService.findUserByLogin(user.getLogin());
        if (userExists != null) {
            result.rejectValue("login", "error.user",
                    "Podany login jest już zarejestrowany w bazie");
        }
        if (result.hasErrors()) {
            returnPage = "register";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", "Rejestracja przebiegła pomyślnie. Możesz się zalogować");
            model.addAttribute("user", new User());

            returnPage = "register";
        }
        return returnPage;
    }
}

