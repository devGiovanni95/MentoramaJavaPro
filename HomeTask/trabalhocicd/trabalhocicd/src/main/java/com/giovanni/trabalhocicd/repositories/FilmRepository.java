package com.giovanni.trabalhocicd.repositories;

import com.giovanni.trabalhocicd.model.Film;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends ReactiveCrudRepository<Film,String> {

//    static void save(String film) {
//
//    }
//
//    public Film save(String film, int note, String commit, int idUser);
//
//    public Film getByName(String name);
//    public Film getById(int id);


}
