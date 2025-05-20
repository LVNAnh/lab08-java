package com.example.lab08.controller;

import com.example.lab08.model.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String processContactForm(ContactForm contactForm, Model model) {
        model.addAttribute("name", contactForm.getName());
        model.addAttribute("email", contactForm.getEmail());
        model.addAttribute("message", contactForm.getMessage());
        return "contact-result";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "About this site";
    }
}