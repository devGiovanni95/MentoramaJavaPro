package br.com.mentorama.webfluxtest.repositories;

import br.com.mentorama.webfluxtest.model.PointEntry;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface PointEntryRepository extends ReactiveCrudRepository<PointEntry, String> {

    Flux<PointEntry> findByUserId(final String id);
}
