package com.khadi.mytransport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/index", "/index.html", "home"})
    public String index(Model model) {
        model.addAttribute("currentPage", "index");
        return "page-template";
    }
}
