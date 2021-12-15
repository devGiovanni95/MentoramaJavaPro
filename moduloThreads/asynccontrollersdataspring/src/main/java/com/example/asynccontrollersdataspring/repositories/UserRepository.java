package com.example.asynccontrollersdataspring.repositories;

import com.example.asynccontrollersdataspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Async("customThreadPool")
public abstract class UserRepository implements JpaRepository<User, Long> {

    public abstract CompletableFuture<Optional<User>> findOneById(final Long id);

    public abstract CompletableFuture<List<User>> findAllBy();
}
