package com.mg.eco.presentation.controller;

import com.mg.eco.bussiness.services.UserService;
import com.mg.eco.presentation.dtos.LoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getLogin(@ModelAttribute("login") LoginDto loginDto) {
        return "login";
    }

    @PostMapping
    public String postLogin(@Valid @ModelAttribute("login") LoginDto loginDto) {
        if (!userService.login(loginDto)) {
            return "login";
        }
        return "redirect:login";
    }
}
