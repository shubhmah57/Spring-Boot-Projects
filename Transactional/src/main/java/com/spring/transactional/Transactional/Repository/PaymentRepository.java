package com.spring.transactional.Transactional.Repository;

import com.spring.transactional.Transactional.Model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<PaymentInfo, String> {
}
