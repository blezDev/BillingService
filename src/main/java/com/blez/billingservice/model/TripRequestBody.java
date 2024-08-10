package com.blez.billingservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TripRequestBody {
    String startDestination, endDestination;
    int  numberOfPassenger, kmPrice;
    String name;
}
