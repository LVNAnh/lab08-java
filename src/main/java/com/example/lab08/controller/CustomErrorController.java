package com.example.lab08.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute("javax.servlet.error.status_code");
        String errorMessage;

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                errorMessage = "Page not found";
            } else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                errorMessage = "Method not allowed for this URL";
            } else {
                errorMessage = "An error occurred: " + statusCode;
            }
        } else {
            errorMessage = "An error occurred";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}