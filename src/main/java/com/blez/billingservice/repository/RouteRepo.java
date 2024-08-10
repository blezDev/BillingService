package com.blez.billingservice.repository;

import com.blez.billingservice.model.CarpoolingRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  RouteRepo extends JpaRepository<CarpoolingRoute, Integer> {
    @Query("SELECT r FROM CarpoolingRoute r WHERE LOWER(r.startCity) = LOWER(:startCity) AND LOWER(r.endCity) = LOWER(:endCity)")
    CarpoolingRoute findByStartCityAndEndCityIgnoreCase(@Param("startCity") String startCity, @Param("endCity") String endCity);

}
