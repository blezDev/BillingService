package com.blez.billingservice.service;

import com.blez.billingservice.model.CarpoolingRoute;
import com.blez.billingservice.model.PublishBillModel;
import com.blez.billingservice.model.TripBillModel;
import com.blez.billingservice.repository.RouteRepo;
import com.blez.billingservice.utils.ResultState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;


@Service
public class BillingServiceImpl implements BillingService {


    @Autowired
    private RouteRepo routeRepo;



    private static final String DIGITS = "12345";
    private static final SecureRandom random = new SecureRandom();

    public static int generateOTP(int length) {
        StringBuilder otp = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(DIGITS.length());
            otp.append(DIGITS.charAt(index));
        }
        return Integer.parseInt(otp.toString());
    }


    @Override
    public ResultState<TripBillModel> getBillingTrip(String startDestination, String endDestination, int numberOfPassenger, int kmPrice, String name) {
        try {
            if (startDestination == null || endDestination == null || numberOfPassenger < 0 || kmPrice < 0) {
                return new ResultState.Error<>("Provided details are invalid");
            }
            CarpoolingRoute route = routeRepo.findByStartCityAndEndCityIgnoreCase(startDestination, endDestination);
            int distanceBetween;
            if (route == null) {
                distanceBetween = generateOTP(3);
            }else{
                distanceBetween = route.getDistanceInKm();
            }

            int fare = kmPrice * distanceBetween;

            int totalFare = (fare * 18 / 100) + fare;

            TripBillModel tripBill = new TripBillModel(name, fare + "", totalFare + "", numberOfPassenger + "", startDestination, endDestination);
            return new ResultState.Success<>(tripBill);


        } catch (Exception e) {
            return new ResultState.Error<>("Error in getting billing trip.");
        }
    }

    @Override
    public ResultState<PublishBillModel> getBillingPublish(String startDestination, String endDestination, int distanceBetween, int numberOfPassenger, int kmPrice,String carModel,String carNumber,String name) {
        try {
            if (startDestination == null || endDestination == null || distanceBetween < 0 || numberOfPassenger < 0 || kmPrice < 0 || carModel ==null || carNumber ==null) {
                return new ResultState.Error<>("Provided details are invalid");
            }
            int fare = kmPrice * distanceBetween;

            int totalFare = (fare * 18 / 100) + fare;

            int commission = totalFare - (totalFare * 40/100);

            PublishBillModel publishBillModel = new PublishBillModel(name,fare + "",commission + "",totalFare + "",numberOfPassenger + "",startDestination,endDestination,carModel,carNumber);
            return new ResultState.Success<>(publishBillModel);


        } catch (Exception e) {
            return new ResultState.Error<>("Error in getting billing trip.");
        }
    }
}
