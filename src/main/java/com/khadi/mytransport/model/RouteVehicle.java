package com.khadi.mytransport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RouteVehicle {
    private long id;
    private long routeId;
    private long vehicleId;
}
