//package com.giovanni.trabalhocicd.jms;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.giovanni.trabalhocicd.model.Film;
//import com.giovanni.trabalhocicd.model.User;
//import com.giovanni.trabalhocicd.repositories.FilmRepository;
//import com.giovanni.trabalhocicd.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//import com.google.gson.Gson;
//
//@RequiredArgsConstructor
//@Component
//public class Consumer {
//
//    private List<Film> film = new ArrayList<>();
//    private final UserRepository personRepository;
//
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
//
//}