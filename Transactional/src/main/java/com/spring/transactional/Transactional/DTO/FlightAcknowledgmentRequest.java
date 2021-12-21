package com.spring.transactional.Transactional.DTO;

import com.spring.transactional.Transactional.Model.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightAcknowledgmentRequest {

    private String status;
    private String pnrNo;
    private double totalFare;
    private PassengerInfo passengerInfo;
}
