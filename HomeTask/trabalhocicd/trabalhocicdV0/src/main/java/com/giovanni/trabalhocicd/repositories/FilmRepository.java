package com.giovanni.trabalhocicd.repositories;

import com.giovanni.trabalhocicd.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer> {

    static void save(String film) {

    }

    public Film save(String film, int note, String commit, int idUser);

    public Film getByName(String name);
    public Film getById(int id);


}
