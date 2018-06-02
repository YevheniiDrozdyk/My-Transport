package com.khadi.mytransport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class Route {
    private long id;
    private String number;
    private int routeRegularity;
    private LocalTime startTime;
    private LocalTime endTime;
    private Set<Stop> stops;
    private double price;
    private boolean contactlessPayment;
    private String contactInfo;
}
