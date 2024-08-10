package com.blez.billingservice.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TripBillModel {

    String name;
    String fare;
    String totalCharges;
    String numberOfPassengers;
    String startDestination;
    String endDestination;




}
