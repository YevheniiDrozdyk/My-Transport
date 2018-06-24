package com.khadi.mytransport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/service", "service.html"})
public class ServiceController {

    @GetMapping
    public String routeInfoPage(Model model) {
        model.addAttribute("currentPage", "service");
        return "page-template";
    }
}
