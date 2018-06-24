package com.khadi.mytransport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping({"/", "/about", "/about.html"})
    public String index(Model model) {
        model.addAttribute("currentPage", "about");
        return "page-template";
    }
}
