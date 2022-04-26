package br.com.mentorama.webfluxtest.repositories;

import br.com.mentorama.webfluxtest.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

}
