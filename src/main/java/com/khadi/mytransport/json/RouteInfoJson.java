package com.khadi.mytransport.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteInfoJson {
    private Boolean status;
    private Integer code;
    private RouteData data;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class RouteData {
        private List<Route> routes;

        @Data
        @NoArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Route {
            private Long id;
            private Double distance;
            private List<Stop> stops;
            @JsonProperty("transports")
            private List<Vehicle> vehicles;

            @Data
            @NoArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public class Stop {
                private String name;
                private Double lon;
                private Double lat;
            }

            @Data
            @NoArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public class Vehicle {
                private Long id;
                private String number;
                private String type;
                private String price;
                private String interval;
                @JsonProperty("work_time")
                private String workTime;
            }
        }
    }
}
