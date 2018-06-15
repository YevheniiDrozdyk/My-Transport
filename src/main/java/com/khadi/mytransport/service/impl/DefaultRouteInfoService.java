package com.khadi.mytransport.service.impl;

import com.khadi.mytransport.model.Route;
import com.khadi.mytransport.model.Stop;
import com.khadi.mytransport.repository.RouteInfoRepository;
import com.khadi.mytransport.service.RouteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRouteInfoService implements RouteInfoService {

    @Autowired
    private RouteInfoRepository routeInfoRepository;

    @Override
    public boolean add(Route route) {
        return false;
    }

    @Override
    public boolean update(long id, Route updated) {
        return false;
    }

    @Override
    public boolean remove(long id) {
        return false;
    }

    @Override
    public Route get(long routeInfoId) {
        return null;
    }

    @Override
    public Route get(String routeNumber) {
        return null;
    }

    @Override
    public boolean addNewStop(long id, Stop stop) {
        return false;
    }
}
