package com.giovanni.trabalhocicd.jms;

import com.giovanni.trabalhocicd.controller.PublishControllerFilm;
import com.giovanni.trabalhocicd.model.Film;
import com.giovanni.trabalhocicd.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Component
public class ConsumerFilm {

    private FilmService filmService;

    public void PublishControllerFilm(FilmService filmService){
        this.filmService = filmService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFilm.class);

//    private List<Film> film = new ArrayList<>();

    @JmsListener(destination = "AvaliacaoFilmes")
    public Mono<Film>FilmessageListener(@RequestBody Film film ){
        LOGGER.info("Cadastro Recebido. {}",film);
        return this.filmService.save(film);

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