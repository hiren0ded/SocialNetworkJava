package com.hiren.social.socialnetwork.controller;

import com.hiren.social.socialnetwork.services.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
/**
 * RestController for User Specific Request
 */
public class UserController {

    @Autowired
    UserRegisterService userRegisterService;


    @PostMapping("/register")
    public boolean register(@RequestParam final String user_id,
                         @RequestParam final String firstName,
                         @RequestParam final String lastName,
                         @RequestParam final String email,
                         @RequestParam final String password){

        return userRegisterService.addUser(user_id, firstName, lastName, email, password);
    }

}
