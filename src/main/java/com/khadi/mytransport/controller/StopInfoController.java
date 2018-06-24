package com.khadi.mytransport.controller;

import com.khadi.mytransport.model.Route;
import com.khadi.mytransport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StopInfoController {
    @Autowired
    private RouteService routeService;

    @GetMapping({"/stop-info"})
    public String showInfo(Model model, long routeId) {
        Route route = routeService.getRoute(routeId);
        model.addAttribute("stops", route.getStops());
        model.addAttribute("currentPage", "stop-info");
        return "page-template";
    }
}
