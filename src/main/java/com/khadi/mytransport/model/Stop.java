package com.khadi.mytransport.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stop")
@Getter
@Setter
public class Stop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "principal_name", unique = true)
    private String principalName;
    private double longitude;
    private double latitude;
    @ManyToMany(mappedBy = "stops")
    private Set<Route> routes = new HashSet<>();
}
