package com.khadi.mytransport.controller;

import com.khadi.mytransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/login","/login.html"})
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("currentPage", "login");
        return "page-template";
    }

    @PostMapping
    public ModelAndView login(@RequestParam String phoneNumber, @RequestParam String password) {
        boolean signedIn = userService.login(phoneNumber, password);
        if (!signedIn) {
            return new ModelAndView("redirect:/login")
                    .addObject("login.message", "There is a problem with phone number or password");
        }

        return new ModelAndView("redirect:/index")
                .addObject("login.message", "Welcome to the system");
    }
}
