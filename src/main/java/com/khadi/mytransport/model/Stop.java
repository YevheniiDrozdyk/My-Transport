package com.khadi.mytransport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Stop {
    private long id;
    private String principalName;
    private double longitude;
    private double latitude;
}
