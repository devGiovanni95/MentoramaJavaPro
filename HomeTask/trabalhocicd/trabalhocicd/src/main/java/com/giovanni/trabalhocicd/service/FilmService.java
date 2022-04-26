package com.giovanni.trabalhocicd.service;

import com.giovanni.trabalhocicd.model.Film;
import com.giovanni.trabalhocicd.repositories.FilmRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository ){
        this.filmRepository = filmRepository;
    }

    public Mono<Film> save(final  Film film){
        return this.filmRepository.save(film);
    }
}
