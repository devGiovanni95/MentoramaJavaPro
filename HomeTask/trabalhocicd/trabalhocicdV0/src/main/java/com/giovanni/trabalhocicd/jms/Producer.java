package com.giovanni.trabalhocicd.jms;

import com.giovanni.trabalhocicd.model.Film;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

@Component
@RequiredArgsConstructor
public class Producer {
    private final JmsTemplate jmsTemplate;

    @Value("${activemq.name}")
    private String destinationQueue;

    public void send(Film film){
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(film);
        jmsTemplate.convertAndSend(destinationQueue, jsonPerson);
    }
}
