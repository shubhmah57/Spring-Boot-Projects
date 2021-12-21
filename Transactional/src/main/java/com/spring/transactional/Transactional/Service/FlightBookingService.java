package com.spring.transactional.Transactional.Service;

import com.spring.transactional.Transactional.DTO.FlightAcknowledgmentRequest;
import com.spring.transactional.Transactional.DTO.FlightBookingRequest;
import com.spring.transactional.Transactional.Model.PassengerInfo;
import com.spring.transactional.Transactional.Model.PaymentInfo;
import com.spring.transactional.Transactional.Repository.PassengerRepository;
import com.spring.transactional.Transactional.Repository.PaymentRepository;
import com.spring.transactional.Transactional.Utils.CreditLimitValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public FlightAcknowledgmentRequest bookFlights(FlightBookingRequest flightBookingRequest){

        PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
        passengerInfo = passengerRepository.save(passengerInfo);

        PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();

        CreditLimitValidationUtil.validateLimit(paymentInfo.getAccountNumber(),
                        paymentInfo.getAmount());

        paymentInfo = paymentRepository.save(paymentInfo);

        FlightAcknowledgmentRequest flightAcknowledgmentRequest =
                    new FlightAcknowledgmentRequest("SUCESS",
                            UUID.randomUUID().toString().split("-")[0],
                            passengerInfo.getFare(),
                            passengerInfo);

        return  flightAcknowledgmentRequest;
    }
}
