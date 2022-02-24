package com.programming.techie.springredditclone.repository;

import com.programming.techie.springredditclone.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("Should save the user in the H2 in memory DB")
    public  void shouldSaveUser(){
        User currentUser = new User(null,
                "test user", "secret",
                "user@gmail.com", Instant.now(),
                true);
        User persistedUser = userRepository.save(currentUser);
        Assertions.assertFalse(persistedUser.getUserId().toString().isEmpty());
    }

}
