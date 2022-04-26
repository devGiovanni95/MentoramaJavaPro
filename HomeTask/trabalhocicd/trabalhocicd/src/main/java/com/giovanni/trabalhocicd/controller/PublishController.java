package com.giovanni.trabalhocicd.controller;

import com.giovanni.trabalhocicd.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/publishFilm")
    public ResponseEntity<String> publishFilm(
            @RequestBody Film film) {
        try {
            jmsTemplate.convertAndSend("AvaliacaoFilmes",film);
            return new ResponseEntity<>("Sent", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
