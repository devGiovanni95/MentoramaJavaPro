package com.giovanni.trabalhocicd.jms;


import com.giovanni.trabalhocicd.model.User;
import com.giovanni.trabalhocicd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Component
public class ConsumerUser {

    private UserService userService;

    public void PublishControllerUser(UserService userService){
        this.userService = userService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerUser.class);

//    private List<Film> film = new ArrayList<>();

    @JmsListener(destination = "User")
    public Mono<User> messageListener(@RequestBody User user ){
        LOGGER.info("Cadastro Recebido. {}",user);
        return this.userService.save(user);
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