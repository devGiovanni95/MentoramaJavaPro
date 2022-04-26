package com.giovanni.trabalhocicd.repositories;

import com.giovanni.trabalhocicd.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User,Integer> {

//    public User getByName(String name);
//    public User getById(int id);


}
