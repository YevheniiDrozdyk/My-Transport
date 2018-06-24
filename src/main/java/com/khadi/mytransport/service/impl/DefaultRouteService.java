package com.khadi.mytransport.service.impl;

import com.khadi.mytransport.model.Route;
import com.khadi.mytransport.repository.RouteRepository;
import com.khadi.mytransport.service.RouteService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultRouteService implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getRoutes() {
        return IteratorUtils.toList(routeRepository.findAll().iterator());
    }

    @Override
    public Route getRoute(long id) {
        return routeRepository.findById(id).orElse(new Route());
    }
}
