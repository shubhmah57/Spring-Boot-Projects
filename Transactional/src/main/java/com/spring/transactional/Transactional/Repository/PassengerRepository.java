package com.spring.transactional.Transactional.Repository;

import com.spring.transactional.Transactional.Model.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<PassengerInfo, Long> {

}
