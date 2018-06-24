package com.khadi.mytransport.controller;

import com.khadi.mytransport.model.Route;
import com.khadi.mytransport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/routeInfo"})
public class RouteInfoController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/all")
    public String getAllRoutesInfo(Model model) {
        List<Route> routes = routeService.getRoutes();
        model.addAttribute("currentPage", "route-info");
        model.addAttribute("routes", routes);

        return "page-template";
    }

    @GetMapping("/byNumber")
    public String getRouteInfo(long id, Model model) {
        Route route = routeService.getRoute(id);
        model.addAttribute("currentPage", "routeInfo");
        model.addAttribute("route", route);

        return "page-template";
    }
}
