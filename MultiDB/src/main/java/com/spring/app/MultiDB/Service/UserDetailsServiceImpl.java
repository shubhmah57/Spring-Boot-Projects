package com.spring.app.MultiDB.Service;

import com.spring.app.MultiDB.Repository.user.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        com.spring.app.MultiDB.Model.User.User repoUser  = userRepository.findByUserName(userName).get();
        User user = null;
        if(repoUser != null){
            user = new User(repoUser.getUserName(),
                                repoUser.getPassword(),
                    new ArrayList<>());
        }
        return user;
    }
}
