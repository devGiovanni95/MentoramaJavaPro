package com.giovanni.trabalhocicd.service;

import com.giovanni.trabalhocicd.model.User;
import com.giovanni.trabalhocicd.repositories.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Mono<User> save(final User user){
        return this.userRepository.save(user);
    }
}
