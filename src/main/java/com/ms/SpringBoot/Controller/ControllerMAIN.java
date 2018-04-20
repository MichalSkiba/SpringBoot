package com.ms.SpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerMAIN {


    @RequestMapping
    public String pokazStrone() {
        return "index";
    }

}
