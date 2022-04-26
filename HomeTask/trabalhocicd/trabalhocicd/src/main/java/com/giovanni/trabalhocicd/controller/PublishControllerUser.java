package com.giovanni.trabalhocicd.controller;

import com.giovanni.trabalhocicd.model.Film;
import com.giovanni.trabalhocicd.model.User;
import com.giovanni.trabalhocicd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PublishControllerUser {

    private UserService userService;

    public  PublishControllerUser(UserService userService){
        this.userService = userService;
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/publishUser")
    public ResponseEntity<User> publishFilm(
            @RequestBody User user) {
        try {
            jmsTemplate.convertAndSend("Users",user);
            return new ResponseEntity<User>( HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/publishUser")
//    public ResponseEntity<String> publishFilm(
//            @RequestBody User user) {
//        try {
//            jmsTemplate.convertAndSend("Users",user);
//            return new ResponseEntity<>("Sent", HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
