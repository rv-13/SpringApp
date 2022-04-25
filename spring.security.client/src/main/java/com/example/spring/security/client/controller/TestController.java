package com.example.spring.security.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

//to control Web Anc
@Controller
public class TestController {

    //Creating mapping for .html templates for our request url mappings
    @RequestMapping("/secure")
    public String securedPage(Model model, Principal principal) {
        return "secure";
    }

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        return "index";
    }
}
