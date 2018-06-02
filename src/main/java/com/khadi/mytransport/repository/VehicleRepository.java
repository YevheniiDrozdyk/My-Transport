package com.khadi.mytransport.repository;

import com.khadi.mytransport.model.Route;
import com.khadi.mytransport.model.Vehicle;

public interface VehicleRepository {

    boolean add(Vehicle vehicle);

    Vehicle get(long id);

    Vehicle get(String registrationNumber);

    boolean setRouteInfo(long id, Route route);
}
