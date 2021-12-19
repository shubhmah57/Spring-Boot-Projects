package com.spring.app.MultiDB.Controller;

import com.spring.app.MultiDB.Model.Authentication.AuthenticationRequest;
import com.spring.app.MultiDB.Model.Authentication.AuthenticationResponse;
import com.spring.app.MultiDB.Service.UserDetailsServiceImpl;
import com.spring.app.MultiDB.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException ex){
            throw new Exception("Incorrect UserName or Password!");
        }
        UserDetails userDetails =
        userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        String jwtToken = jwtUtil.generateToken(userDetails);

        return  ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return  "hello";
    }
}
