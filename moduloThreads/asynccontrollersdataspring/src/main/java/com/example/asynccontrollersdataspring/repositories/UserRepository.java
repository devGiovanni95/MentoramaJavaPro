package com.example.asynccontrollersdataspring.repositories;

import com.example.asynccontrollersdataspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Async("customThreadPool")
@Repository//estava faltando a anotação e tava como classe ao inves de interface
public interface  UserRepository extends JpaRepository<User, Long> {

      CompletableFuture<Optional<User>> findOneById(final Long id);

      CompletableFuture<List<User>> findAllBy();
}
