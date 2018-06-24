package com.khadi.mytransport.repository.impl;

import com.khadi.mytransport.json.RouteInfoJson;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Deprecated
public class WebServiceRouteInfoRepository {
    private static final String GET_ALL_ROUTES_URL = "https://brainluck.pro/api/v1/routes";
    private static final String GET_ROUTE_BY_ID_URL = "https://brainluck.pro/api/v1/routes/{%id}";

    public List<RouteInfoJson.RouteData.Route> getRoutes() {
        RestTemplate restTemplate = new RestTemplate();
        RouteInfoJson routeInfoJson = restTemplate.getForObject(GET_ALL_ROUTES_URL, RouteInfoJson.class);
        return routeInfoJson.getData().getRoutes();
    }

    public RouteInfoJson.RouteData.Route getRoute(long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(GET_ROUTE_BY_ID_URL, id);
        RouteInfoJson routeInfoJson = restTemplate.getForObject(url, RouteInfoJson.class);
        return routeInfoJson.getData().getRoutes().get(0);
    }
}