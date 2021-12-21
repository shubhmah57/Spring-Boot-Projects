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
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class FlightBookingService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public FlightAcknowledgmentRequest bookFlights(FlightBookingRequest flightBookingRequest){

        PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
        passengerInfo = passengerRepository.save(passengerInfo);
//        System.out.println("---------PassengerInfo------------------");
//        System.out.println(flightBookingRequest.getPassengerInfo());
//        System.out.println("---------PaymentInfo-------------");
        System.out.println(flightBookingRequest.getPaymentInfo());
        PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();

        CreditLimitValidationUtil.validateLimit(paymentInfo.getAccountNumber(),
                        passengerInfo.getFare());

        paymentInfo = paymentRepository.save(paymentInfo);
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        FlightAcknowledgmentRequest flightAcknowledgmentRequest =
                    new FlightAcknowledgmentRequest("SUCESS",
                            UUID.randomUUID().toString().split("-")[0],
                            passengerInfo.getFare(),
                            passengerInfo);

        return  flightAcknowledgmentRequest;
    }
}
