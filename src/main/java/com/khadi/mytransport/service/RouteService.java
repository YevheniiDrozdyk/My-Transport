package com.khadi.mytransport.service;

import com.khadi.mytransport.model.Route;

import java.util.List;

public interface RouteService {

    List<Route> getRoutes();

    Route getRoute(long id);
}
