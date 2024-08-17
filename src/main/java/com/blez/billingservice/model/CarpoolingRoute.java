package com.blez.billingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarpoolingRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RouteID")
    private int routeId;

    @Column(name = "StartCity", nullable = false, length = 100)
    private String startCity;

    @Column(name = "EndCity", nullable = false, length = 100)
    private String endCity;

    @Column(name = "DistanceInKm", nullable = false, precision = 6, scale = 2)
    private int distanceInKm;

    public CarpoolingRoute(String startCity, String endCity, int distanceInKm) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.distanceInKm = distanceInKm;
    }
}
