package com.ms.SpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class ControllerLogin {


    @RequestMapping
    public String pokazStrone() {
        return "login";
    }


}
