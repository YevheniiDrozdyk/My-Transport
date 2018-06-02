package com.khadi.mytransport.controller;

import com.khadi.mytransport.model.User;
import com.khadi.mytransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/user/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("getById")
    public String getById(@RequestParam long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        model.addAttribute("currentPage", "index");
        return "page-template";
    }

    @GetMapping("getByPhone")
    public String getByPhoneNumber(@RequestParam String phone, Model model) {
        User user = userService.get("+380" + phone);
        model.addAttribute("user", user);
        model.addAttribute("currentPage", "index");
        return "page-template";
    }

    @PostMapping("create")
    public String create(@RequestParam String phone, @RequestParam String password,
                         @RequestParam String firstName, @RequestParam String lastName,
                         @RequestParam String email, @RequestParam LocalDate birthDay,
                         @RequestParam String address) {

        return "";
    }
}
