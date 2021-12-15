package com.example.asynccontrollersdataspring.services;

import com.example.asynccontrollersdataspring.models.User;
import com.example.asynccontrollersdataspring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public CompletableFuture<Optional<User>> findById(Long id){
        System.out.println("ServiceThread: " + Thread.currentThread().getName());
        return  this.userRepository.findOneById(id);
    }

    public CompletableFuture<List<User>> findAll(){
        System.out.println("ServiceThread: " + Thread.currentThread().getName());

        return userRepository.findAllBy();
    }

    public CompletableFuture<User> save(final User user){
        System.out.println("ServiceThread: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(userRepository.save(user));

    }

}
