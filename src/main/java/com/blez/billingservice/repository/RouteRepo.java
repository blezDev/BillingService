package com.blez.billingservice.repository;

import com.blez.billingservice.model.CarpoolingRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  RouteRepo extends JpaRepository<CarpoolingRoute, Integer> {
    CarpoolingRoute findByStartCityAndEndCity(String startCity, String endCity);
}
