package com.spring.app.MultiDB.Controller;

import com.spring.app.MultiDB.Model.User.User;
import com.spring.app.MultiDB.Service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserSaveService userSaveService;


    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestBody User user){
        userSaveService.persistUser(user);
        return ResponseEntity.ok("UserCreatedSuccess");
    }

    @GetMapping("/details")
    public ResponseEntity<String> publishDetails(){
        return ResponseEntity.ok("HelloWorld");
    }

}
