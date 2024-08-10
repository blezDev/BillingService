package com.blez.billingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PublishRequestBody {
    String startDestination;
    String endDestination;
    int distanceBetween;
    int numberOfPassenger;
    int kmPrice;
    String carModel;
    String carNumber;
    String name;
}
