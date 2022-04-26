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
public class PublishControllerFilm {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/publishFilm")
    public ResponseEntity<Film> publishFilm(
            @RequestBody Film film) {
        try {
            jmsTemplate.convertAndSend("AvaliacaoFilmes",film);
            return new ResponseEntity<Film>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Film>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
