package com.khadi.mytransport.controller;

import com.khadi.mytransport.service.RouteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/routeInfo","routeInfo.html"})
public class RouteInfoController {

    @Autowired
    private RouteInfoService routeInfoService;

    @GetMapping
    public String routeInfoPage(Model model) {
        model.addAttribute("currentPage", "service");
        return "page-template";
    }

    @GetMapping("/all")
    public ModelAndView getAllRoutesInfo() {
        return null;
    }

    @GetMapping("/byNumber")
    public ModelAndView getRouteInfo(String routeNumber) {
        return null;
    }
}
