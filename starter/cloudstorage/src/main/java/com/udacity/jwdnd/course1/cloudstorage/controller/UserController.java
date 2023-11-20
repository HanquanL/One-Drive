package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("")
public class UserController {

    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String loginError = null;


        if(loginError == null){
            return ResponseEntity.ok().body("Login successful");
        } else {
            return ResponseEntity.badRequest().body(loginError);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody User user){
        String signupError = null;

        if(!userService.isUsernameAvailable(user.getUsername())){
            signupError = "The username already exists.";
        }

        if(signupError == null){
            int rowsAdded = userService.createUser(user).getUserid();
            if(rowsAdded < 0){
                signupError = "There was an error signing you up. Please try again.";
            }
        }

        if(signupError == null){
            return ResponseEntity.ok().body("signup successful");
        } else {
            return ResponseEntity.badRequest().body(signupError);
        }


    }
}
