package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.services.AuthenticationService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("")
public class UserController {

    private UserService userService;
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication auth = authenticationService.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (auth != null) {
            return ResponseEntity.ok().body("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody User user){
        String signupError = null;

        if(!userService.isUsernameAvailable(user.getUsername())){
            signupError = "The username already exists.";
        }

        if(signupError == null){
            Long rowsAdded = userService.createUser(user).getUserid();
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
