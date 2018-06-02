package com.khadi.mytransport.model;

import com.khadi.mytransport.constant.Color;
import com.khadi.mytransport.constant.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Vehicle {
    private long id;
    private String registrationNumber;
    private Color color;
    private VehicleType vehicleType;
}
