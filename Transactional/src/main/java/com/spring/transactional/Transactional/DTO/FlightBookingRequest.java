package com.spring.transactional.Transactional.DTO;


import com.spring.transactional.Transactional.Model.PassengerInfo;
import com.spring.transactional.Transactional.Model.PaymentInfo;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;
}
