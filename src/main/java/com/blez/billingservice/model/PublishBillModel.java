package com.blez.billingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PublishBillModel {
    String name;
    String fare;
    String Commissions;
    String totalCharges;
    String numberOfPassengers;
    String startDestination;
    String endDestination;
    String carModel;
    String carNumber;
}
