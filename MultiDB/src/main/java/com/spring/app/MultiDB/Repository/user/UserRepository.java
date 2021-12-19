package com.spring.app.MultiDB.Repository.user;


import com.spring.app.MultiDB.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String name);
}
