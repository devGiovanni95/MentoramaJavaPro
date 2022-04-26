package com.giovanni.trabalhocicd.jms;

import java.util.ArrayList;
import java.util.List;

import com.giovanni.trabalhocicd.model.Film;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private List<Film> film = new ArrayList<>();

    @JmsListener(destination = "AvaliacaoFilmes")
    public void messageListener(Film film ){
        LOGGER.info("Cadastro Recebido. {}",film);

    }

//    @JmsListener( destination = "${activemq.name}" )
//    public void listen(String film,int note,String commit,int idUser) {
//        System.out.println(film);
//        System.out.println(note);
//        System.out.println(commit);
//        System.out.println(idUser);
//
//
//        Film Film = new Film();
//        try {
//            Gson gson = new Gson();
//            Film = gson.fromJson(film, Film.class);
//            FilmRepository.save(film);
//        }catch(Exception e){
//
//        }
//    }

}