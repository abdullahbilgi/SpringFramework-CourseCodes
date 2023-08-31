package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyloginPage")
    public String showMyLoginPage(){

        //return "plain-login";
        return "fancy-login";
    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied(){

        //return "plain-login";
        return "access-denied";
    }

}
