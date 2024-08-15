package com.blez.billingservice.service;

import com.blez.billingservice.model.CarpoolingRoute;
import com.blez.billingservice.model.PublishBillModel;
import com.blez.billingservice.model.TripBillModel;
import com.blez.billingservice.utils.ResultState;

import java.util.List;

public interface BillingService {

    public ResultState<TripBillModel> getBillingTrip(String startDestination, String endDestination, int numberOfPassenger, int kmPrice, String name);

    public ResultState<PublishBillModel> getBillingPublish(String startDestination, String endDestination, int distanceBetween, int numberOfPassenger, int kmPrice, String carModel, String carNumber, String name);

    public ResultState<List<CarpoolingRoute>> getAllCarpoolingRoutes();
}
