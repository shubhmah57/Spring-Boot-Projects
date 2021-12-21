package com.spring.transactional.Transactional.Controllers;

import com.spring.transactional.Transactional.DTO.FlightAcknowledgmentRequest;
import com.spring.transactional.Transactional.DTO.FlightBookingRequest;
import com.spring.transactional.Transactional.Service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlighBookingController {

    @Autowired
    FlightBookingService flightBookingService;

    @RequestMapping(value = "/bookFLights", method = RequestMethod.POST)
    public ResponseEntity<FlightAcknowledgmentRequest> bookFLights(@RequestBody FlightBookingRequest flightBookingRequest){
        FlightAcknowledgmentRequest acknowledgmentRequest =flightBookingService.bookFlights(flightBookingRequest);
        return ResponseEntity.ok(acknowledgmentRequest);
    }
}
