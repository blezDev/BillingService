package com.blez.billingservice.controller;


import com.blez.billingservice.model.*;
import com.blez.billingservice.model.ResponseBody;
import com.blez.billingservice.service.BillingService;
import com.blez.billingservice.utils.ResultState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillingService billingService;

    @PostMapping("/trip")
    public ResponseEntity<ResponseBody> generateTripBill(@RequestBody TripRequestBody trip) {
        ResultState<TripBillModel> resultState = billingService.getBillingTrip(trip.getStartDestination(),
                trip.getEndDestination(),
                trip.getNumberOfPassenger(),
                trip.getKmPrice(),
                trip.getName());

        if (resultState instanceof ResultState.Success<TripBillModel> success) {

            return ResponseEntity.ok(new ResponseBody("Trip Bill", success.getData()));
        } else {
            ResultState<TripBillModel> resultState1 = resultState;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseBody(resultState1.getMessage(), resultState1.getData()));
        }

    }

    @PostMapping("/publish")
    public ResponseEntity<ResponseBody> generatePublishTrip(@RequestBody PublishRequestBody publish) {
        ResultState<PublishBillModel> resultState = billingService.getBillingPublish(publish.getStartDestination(), publish.getEndDestination(), publish.getDistanceBetween(), publish.getNumberOfPassenger(), publish.getKmPrice(), publish.getCarModel(), publish.getCarNumber(), publish.getName());

        if (resultState instanceof ResultState.Success<PublishBillModel> success) {

            return ResponseEntity.ok(new ResponseBody("Publish Bill",success.getData()));
        } else {
            ResultState<PublishBillModel> error = resultState;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseBody(error.getMessage(),error.getMessage()));
        }

    }


}
