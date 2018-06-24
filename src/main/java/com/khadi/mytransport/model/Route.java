package com.khadi.mytransport.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "route")
@Getter
@Setter
public class Route implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    @Column(name = "route_regularity")
    private int routeRegularity;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "route_stop",
            joinColumns = {@JoinColumn(name = "route_id")},
            inverseJoinColumns = {@JoinColumn(name = "stop_id")}
    )
    private Set<Stop> stops = new HashSet<>();
    private double price;
    @Column(name = "contactless_payment")
    private boolean contactlessPayment;
    @Column(name = "contact_info")
    private String contactInfo;
    private double distance;
}
