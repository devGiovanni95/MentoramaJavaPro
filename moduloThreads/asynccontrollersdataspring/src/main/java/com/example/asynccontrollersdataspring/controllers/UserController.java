package com.example.asynccontrollersdataspring.controllers;

import com.example.asynccontrollersdataspring.exceptions.UserNotFound;
import com.example.asynccontrollersdataspring.models.User;
import com.example.asynccontrollersdataspring.services.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/user")
@RestController
@Async
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public CompletableFuture<List<User>> findAll() {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public CompletableFuture<User> findById(@PathVariable("id") final Long id) {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.userService.findById(id)
                .thenApply(x -> {
                    try {
                        return x.orElseThrow(UserNotFound::new);
                    } catch (UserNotFound e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    @PostMapping
    public CompletableFuture<User> save(@RequestBody final User user) {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.userService.save(user);
    }

}
