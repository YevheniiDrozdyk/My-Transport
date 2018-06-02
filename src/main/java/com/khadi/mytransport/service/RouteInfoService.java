package com.khadi.mytransport.service;

import com.khadi.mytransport.model.Route;
import com.khadi.mytransport.model.Stop;

public interface RouteInfoService {

    boolean add(Route route);

    boolean update(long id, Route updated);

    boolean remove(long id);

    Route get(long routeInfoId);

    Route get(String routeNumber);

    boolean addNewStop(long id, Stop stop);
}
