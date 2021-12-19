package com.spring.app.MultiDB.Service;

import com.spring.app.MultiDB.Model.User.User;
import com.spring.app.MultiDB.Repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSaveServiceImpl implements  UserSaveService{

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void persistUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(
                user.getPassword()
        ));

        userRepository.save(user);
    }
}
